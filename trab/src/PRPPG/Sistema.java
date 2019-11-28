package PRPPG;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

// import sun.security.util.Length;

public class Sistema {
	//ATRIBUTOS
	public int ano;
	public HashMap<Long, Docente> docentes;
	public HashMap<String, Veiculo> veiculos;
	public ArrayList<Publicacao> publicacoes;
	public ArrayList<Qualis> qualis;
	public ArrayList<Regra> regras;
	//METODOS
	// constructor
	public Sistema(int ano) {
		this.docentes = new HashMap<Long, Docente>();
		this.veiculos = new HashMap<String, Veiculo>();
		this.publicacoes = new ArrayList<Publicacao>();
		this.qualis = new ArrayList<Qualis>();
		this.regras = new ArrayList<Regra>();
		this.setAno(ano);
	}
	// setters
	private void setAno(int ano) {this.ano = ano;}
	// getters
	public int getAno() {return this.ano;}
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
		this.gerarRelatorioRecredenciamento("recredenciamento.csv");
		this.gerarRelatorioPublicacoes("publicacoes.csv");
		this.gerarRelatorioEstatisticas("estatisticas.csv");
	}

	// READ
	public void read(String[] args) {
		for(int i = 0; i <= args.length - 1; i++) {
			switch (args[i]) {
				case "-d":
					this.loadDocentes(args[i], args[i + 1]);
					break;
				
				case "-v":
					this.loadVeiculos(args[i], args[i + 1]);
					break;
				
				case "-p":
					this.loadPublicacoes(args[i], args[i + 1]);
					break;
				
				case "-q":
					this.loadQualis(args[i], args[i + 1]);
					break;
				
				case "-r":
					this.loadRegras(args[i], args[i + 1]);
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
	public void loadDocentes(String args1, String args2) {
		long cod;
		boolean coord;
		String line;
		String[] infoDocentes;
		Calendar dateN = Calendar.getInstance();
		Calendar dateI = Calendar.getInstance();
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
		try {
			BufferedReader bufferD = new BufferedReader(new InputStreamReader(new  FileInputStream(args2)));
			line = bufferD.readLine();	// Ignora a primeira linha de leitura
			line = bufferD.readLine();
			while(line != null) {
				infoDocentes = line.split(";");
				cod = Long.parseLong(infoDocentes[0]);
				dateN.setTime(dma.parse(infoDocentes[2]));
				dateI.setTime(dma.parse(infoDocentes[3]));
				if(infoDocentes.length == 5) {coord = true;}
				else {coord = false;}
				Docente doc = new Docente(cod, infoDocentes[1], coord, dateN, dateI);
				//System.out.println(doc.toString());
				this.docentes.put(doc.getCodigo(), doc);
				line = bufferD.readLine();
			}
			bufferD.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}
	}
	
	// LEITURA DE VEICULOS
	public void loadVeiculos(String args1, String args2) {
		char tipo;
		float impacto;
		String line;
		String[] infoVeiculos;
			try {
				BufferedReader bufferV = new BufferedReader(new InputStreamReader(new  FileInputStream(args2)));
				line = bufferV.readLine();	// Ignora a primeira linha de leitura
				line = bufferV.readLine();
				while(line != null) {
					Veiculo veic = null;
					infoVeiculos = line.split(";");
					tipo = infoVeiculos[2].charAt(0);
					impacto = Float.parseFloat(infoVeiculos[3].replace(',','.'));

					switch (tipo) {
						case 'P':
						case 'p':
							veic = new Periodico(tipo, infoVeiculos[1], infoVeiculos[4], infoVeiculos[0].trim(), impacto);
							break;
						
						case 'C':
						case 'c':
							veic = new Conferencia(tipo, infoVeiculos[1], infoVeiculos[0].trim(), impacto);
						default:
							System.err.printf("Inconsistencia na entrada.\n");
							break;
					}
					
					//System.out.println(veic.toString());
					this.veiculos.put(veic.getSigla(), veic);
					line = bufferV.readLine();
				}
				bufferV.close();
	    	} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
	}
	
	// LEITURA DE QUALIS
	public void loadQualis(String args1, String args2) {
		int ano;
		double pont;
		String line;
		String[] infoQualis;
		try {
			BufferedReader bufferQ = new BufferedReader(new InputStreamReader(new  FileInputStream(args2)));
			line = bufferQ.readLine(); // Ignora a primeira linha
			line = bufferQ.readLine();
			while(line != null) {
				infoQualis = line.split(";");
				ano = Integer.parseInt(infoQualis[0]);
				Qualis quali = new Qualis(ano, infoQualis[2]);
				//System.out.println(quali.toString());
				this.qualis.add(quali);
				Veiculo veic = this.veiculos.get(infoQualis[1].trim());
				veic.addQualis(quali);
				//veic.printQualis();
				//veic.printPublicacoes();
				line = bufferQ.readLine();
			}
			bufferQ.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
	}
	
	// LEITURA DE REGRAS
	public void loadRegras(String args1,String args2){
		int anos;
		int pontMin;
		float multp;
		Calendar dateI = Calendar.getInstance();
		Calendar dateF = Calendar.getInstance();
		String line;
		String[] infoRegras;
		String[] listQualis;
		SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
		try {
			BufferedReader bufferR = new BufferedReader(new InputStreamReader(new  FileInputStream(args2)));
			line = bufferR.readLine(); // Ignora a primeira linha
			line = bufferR.readLine();
			while(line != null) {
				infoRegras = line.split(";");
				for(String s: infoRegras){s = s.trim();}
				listQualis = infoRegras[2].split(",");
				for(String s: listQualis){s = s.trim();}
				dateI.setTime(dma.parse(infoRegras[0]));
				dateF.setTime(dma.parse(infoRegras[1]));
				multp = Float.parseFloat(infoRegras[4].replace(',','.'));
				anos = Integer.parseInt(infoRegras[5]);
				pontMin = Integer.parseInt(infoRegras[6]);
				Regra r = new Regra(pontMin, anos, multp, dateI, dateF);
				System.out.println(r.toString());
				this.regras.add(r);
				line = bufferR.readLine();
			}
			bufferR.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
		catch (ParseException e) {System.err.printf("Erro para converter a Data.\n");}
	}

	// LEITURA DE PUBLICACOES
	public void loadPublicacoes(String args1,String args2){
		int num;
		int pagI;
		int pagF;
		int anoPubli;
		String line;
		String[] infoPublicacoes;
		String[] listDocs;
		try {
			BufferedReader bufferP = new BufferedReader(new InputStreamReader(new  FileInputStream(args2)));
			line = bufferP.readLine(); // Ignora a primeira linha
			line = bufferP.readLine();
			while(line != null) {
				infoPublicacoes = line.split(";");
				for(String s: infoPublicacoes){s = s.trim();}
				num = Integer.parseInt(infoPublicacoes[4]);
				anoPubli = Integer.parseInt(infoPublicacoes[0]);
				pagI = Integer.parseInt(infoPublicacoes[7]);
				pagF = Integer.parseInt(infoPublicacoes[8]);
				Publicacao publi = new Publicacao(infoPublicacoes[2], num, anoPubli, pagI, pagF);
				this.publicacoes.add(publi);
				listDocs = infoPublicacoes[3].split(",");
				for(int i = 0; i < listDocs.length; i++) {
					Docente doc = this.docentes.get(Long.parseLong(listDocs[i].trim()));
					doc.addPublicacao(publi);
					//doc.printPublicacoes();
				}
				Veiculo veic = this.veiculos.get(infoPublicacoes[1].trim());
				veic.addPublicacao(publi);
				if(veic.getTipo() == 'C') {publi.setVolumeLocal(infoPublicacoes[6]);}
				else if(veic.getTipo() == 'P'){publi.setVolumeLocal(infoPublicacoes[5]);}
				else {System.out.printf("Erro de Parse \n");}
				//System.out.println(publi.toString());
				line = bufferP.readLine();
			}
			bufferP.close();
		} catch (IOException e) {System.err.printf("Erro na abertura do Arquivo %s.\n", e.getMessage());}
	}

	public void gerarRelatorioRecredenciamento(String nomeArq) {
		File diretorio = new File(nomeArq)
	}

	public void gerarRelatorioPublicacoes(String nomeArq) {

	}

	public void gerarRelatorioEstatisticas(String nomeArq) {

	}
}