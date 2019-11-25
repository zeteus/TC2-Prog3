package PRPPG;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Sistema {
    
	public static void main(String[] args) {
//    	ArrayList<Docente> docentes = loadDocentes(args[0], args[1]);
//    	ArrayList<Veiculo> veiculos = loadVeiculos(args[0], args[1]);
//    	ArrayList<Qualis>  qualis 	= loadQualis(veiculos, args[0], args[1]);
//		ArrayList<Regra>   regras	= loadRegras(args[0], args[1]);
    }
	
	// LEITURA DE DOCENTES
	public ArrayList<Docente> loadDocentes(String args1, String args2) {
		int cod;
		boolean coord;
		String line;
		String[] infoDocentes;
		Calendar dateN = Calendar.getInstance();
		Calendar dateI = Calendar.getInstance();
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		try {
			BufferedReader bufferD = new BufferedReader(new InputStreamReader(new  FileInputStream(args1), args2));
			line = bufferD.readLine();	// Ignora a primeira linha de leitura
			while(line != null) {
				line = bufferD.readLine();
				infoDocentes = line.split(";");
				cod = Integer.parseInt(infoDocentes[0]);
				dateN.setTime(dma.parse(infoDocentes[2]));
				dateI.setTime(dma.parse(infoDocentes[3]));
				if(infoDocentes.length == 5) {coord = true;}
				else {coord = false;}
				Docente doc = new Docente(cod, infoDocentes[1], coord, dateN, dateI);
				docentes.add(doc);
			}
			bufferD.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}
		return docentes;
	}
	
	// LEITURA DE VEICULOS
	public HashMap<String, Veiculo> loadVeiculos(String args1, String args2) {
		char tipo;
		float impacto;
		String line;
		String[] infoVeiculos;
		HashMap<String, Veiculo> veiculos = new HashMap<String, Veiculo>();
			try {
				BufferedReader bufferV = new BufferedReader(new InputStreamReader(new  FileInputStream(args1), args2));
				line = bufferV.readLine();	// Ignora a primeira linha de leitura
				while(line != null) {
					line = bufferV.readLine();
					infoVeiculos = line.split(";");
					tipo = infoVeiculos[2].charAt(0);
					impacto = Float.parseFloat(infoVeiculos[3]);
					Veiculo veic = null;
					if(tipo == 'P') {veic = new Periodico(tipo, infoVeiculos[1], infoVeiculos[4], infoVeiculos[0], impacto);}
					else if(tipo == 'C') {veic = new Conferencia(tipo, infoVeiculos[1], infoVeiculos[0], impacto);}
					else {System.err.printf("Inconsistencia na entrada.\n");}
					veiculos.put(veic.getSigla(), veic);
				}
				bufferV.close();
	    	} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
			return veiculos;
	}
	
	// LEITURA DE QUALIS
	public ArrayList<Qualis> loadQualis(HashMap<String, Veiculo> veiculos, String args1, String args2) {
		int ano;
		double pont;
		String line;
		String[] infoQualis;
		ArrayList<Qualis> qualis = new ArrayList<Qualis>();
		try {
			BufferedReader bufferQ = new BufferedReader(new InputStreamReader(new  FileInputStream(args1), args2));
			line = bufferQ.readLine(); // Ignora a primeira linha
			while(line != null) {
				line = bufferQ.readLine();
				infoQualis = line.split(";");
				ano = Integer.parseInt(infoQualis[0]);
				pont = 1; // TODO precisa olhar a regra
				Qualis quali = new Qualis(ano, pont, infoQualis[2]);
				qualis.add(quali);
				Veiculo veic = veiculos.get(infoQualis[1]);
				veic.addQualis(quali);
			}
			bufferQ.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		return qualis;
	}
	
	// LEITURA DE REGRAS
	public ArrayList<Regra> loadRegras(String args1,String args2){
		int anos;
		int pontMin;
		Calendar dateI = Calendar.getInstance();
		Calendar dateF = Calendar.getInstance();
		String line;
		String[] infoRegras;
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Regra> regras = new ArrayList<Regra>();
		try {
			BufferedReader bufferR = new BufferedReader(new InputStreamReader(new  FileInputStream(args1), args2));
			line = bufferR.readLine(); // Ignora a primeira linha
			while(line != null) {
				line = bufferR.readLine();
				infoRegras = line.split(";");
				dateI.setTime(dma.parse(infoRegras[0]));
				dateF.setTime(dma.parse(infoRegras[1]));
				anos = Integer.parseInt(infoRegras[5]);
				pontMin = Integer.parseInt(infoRegras[6]);
				Regra r = new Regra(pontMin, anos, dateI, dateF);
				regras.add(r);
			}
			bufferR.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}
		return regras;
	}
}