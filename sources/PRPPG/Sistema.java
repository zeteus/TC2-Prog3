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

import sun.security.util.Length;

public class Sistema {
	//ATRIBUTOS
	public int ano;
	public ArrayList<Docente> docentes;
	public HashMap<String, Veiculo> veiculos;
	public ArrayList<Publicacao> publicacoes;
	public ArrayList<Qualis> qualis;
	public ArrayList<Regra> regras;
	//METODOS
	// setters
	public void setAno(int ano) {this.ano = ano;}
	public void setDocentes(ArrayList<Docente> doc) {this.docentes = doc;}
	public void setPublicacoes(ArrayList<Publicacao> publi) {this.publicacoes = publi;}
	public void setVeiculos(HashMap<String, Veiculo> veic) {this.veiculos = veic;}
	public void setQualis(ArrayList<Qualis> qualis) {this.qualis = qualis;}
	public void setRegras(ArrayList<Regra> regras) {this.regras = regras;}
	// getters
	public int getAno() {return this.ano;}
	public ArrayList<Docente> getDocentes() {return this.docentes;}
	public ArrayList<Publicacao> getPublicacoes() {return this.publicacoes;}
	public HashMap<String, Veiculo> getVeiculos() {return this.veiculos;}
	public ArrayList<Qualis> getQualis() {return this.qualis;}
	public ArrayList<Regra> getRegras() {return this.regras;}
	// MAIN
	public static void main(String[] args) {
		Sistema PPGI = new Sistema();
		switch (args[0]) {
			case "--read-only":
				PPGI.read(args);
				break;
			
			case "--write-only":
				PPGI.write(args);
				break;
			
			default:
				PPGI.read(args);
				PPGI.write(args);
				break;
		}
	}

	// WRITE
	public void write(String[] args) {
		
	}

	// READ
	public void read(String[] args) {
		for(int i = 0; i = args.length - 1; i++) {
			switch (args[i]) {
				case "-d":
					this.setDocentes(this.loadDocentes(args[i], args[i + 1]));
					break;
				
				case "-v":
					this.setVeiculos(this.loadVeiculos(args[i], args[i + 1]));
					break;
				
				case "-p":
					this.setPublicacoes(this.loadPublicacoes(args[i], args[i + 1]));
					break;
				
				case "-q":
					this.setQualis(this.loadQualis(args[i], args[i + 1]));
					break;
				
				case "-r":
					this.setRegras(this.loadRegras(args[i], args[i + 1]));
					break;
				
				case "-a":
					this.setAno(Integer.parseInt(args[i + 1]));
					break;
				
				default:
					break;
			}
		}
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
	public ArrayList<Qualis> loadQualis(String args1, String args2) {
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
				Veiculo veic = this.veiculos.get(infoQualis[1]);
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
		float multp;
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
				multp = Float.parseFloat(infoRegras[4]);
				anos = Integer.parseInt(infoRegras[5]);
				pontMin = Integer.parseInt(infoRegras[6]);
				Regra r = new Regra(pontMin, anos, multp, dateI, dateF);
				regras.add(r);
			}
			bufferR.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}
		return regras;
	}

	// LEITURA DE PUBLICACOES
	public ArrayList<Publicacao> loadPublicacoes(String args1,String args2){
		int codigo;
		int anoPubli;
		String line;
		String[] infoPublicacoes;
		ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
		try {
			BufferedReader bufferP = new BufferedReader(new InputStreamReader(new  FileInputStream(args1), args2));
			line = bufferP.readLine(); // Ignora a primeira linha
			while(line != null) {
				line = bufferP.readLine();
				infoPublicacoes = line.split(";");
				codigo = Integer.parseInt(infoPublicacoes[5]);
				anoPubli = Integer.parseInt(infoPublicacoes[0]);
				Publicacao publi = new Publicacao(infoPublicacoes[2], codigo, anoPubli);
				publicacoes.add(publi);
			}
			bufferP.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		return publicacoes;
	} 
}