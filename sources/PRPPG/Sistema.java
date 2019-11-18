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
import java.util.List;

public class Sistema {
    
	public static void main(String[] args) {
    	try {
			int cod;
			int ano;
			int pont;
			char tipo;
			String line;
			float impacto;
			boolean coord;
			Calendar dateN = Calendar.getInstance();
			Calendar dateI = Calendar.getInstance();
			SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
			
			// LEITURA DE DOCENTES
			ArrayList<Docente> docentes = new ArrayList<Docente>();
			BufferedReader bufferD = new BufferedReader(new InputStreamReader(new  FileInputStream(args[0]), args[1]));
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
			
			// LEITURA DE VEICULOS
			HashMap<String, Veiculo> veiculos = new HashMap<String, Veiculo>();
			BufferedReader bufferV = new BufferedReader(new InputStreamReader(new  FileInputStream(args[0]), args[1]));
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
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}

//    	ArrayList<Docente> docentes = loadDocentes();
//    	ArrayList<Veiculo> veiculos = loadVeiculos();
//    	ArrayList<Qualis> qualis = loadQualis(veiculos);
    	
    }
	public ArrayList<Docente> loadDocentes() {
		String line;
		String[] infoDocentes;
		ArrayList<Docente> docentes = new ArrayList<Docente>();
		try {
			BufferedReader bufferD = new BufferedReader(new InputStreamReader(new  FileInputStream(args[0]), args[1]));
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
	}
	public ArrayList<Qualis> loadQualis(HashMap<String, Veiculo> veiculos) {
		int ano;
		double pont;
		String line;
		String[] infoQualis;
		ArrayList<Qualis> qualis = new ArrayList<Qualis>();
		try {
			BufferedReader bufferQ = new BufferedReader(new InputStreamReader(new  FileInputStream(args[0]), args[1]));
			line = bufferQ.readLine(); // Ignora a priimeira linha
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
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}
		return qualis;
	}
}