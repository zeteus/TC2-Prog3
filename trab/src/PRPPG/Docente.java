package PRPPG;

import java.util.Calendar;
import java.util.HashMap;

public class Docente {
    public long codigo;
    public String nome;
    public boolean coordenador;		
    public Calendar dataNascimento;
    public Calendar dataIngresso;
    public HashMap<String, Publicacao> publicacoes;

    // METODOS
    // constructor
    public Docente(long codigo, String nome, boolean coordenador, Calendar dataNascimento, Calendar dataIngresso) {
    	super();
    	this.codigo = codigo;
    	this.nome = nome;
    	this.coordenador = coordenador;
    	this.dataNascimento = dataNascimento;
        this.dataIngresso = dataIngresso;
        this.publicacoes = new HashMap<String, Publicacao>();
    }
	// setters
    private void setCodigo(long cod) {this.codigo = cod;}
	private void setNome(String nome) {this.nome = nome;}
    private void setCoordenador(boolean coord) {this.coordenador = coord;}
    private void setDataNascimento(Calendar dataN) {this.dataNascimento = dataN;}
    private void setDataIngresso(Calendar dataI) {this.dataIngresso = dataI;}
    // getters
    public long getCodigo() {return this.codigo;}
    public String getNome() {return this.nome;}
    public boolean getCoordenador() {return this.coordenador;}
    public Calendar getDataNascimento() {return this.dataNascimento;}
    public Calendar getDataIngresso() {return this.dataIngresso;}

    public void quaisSaoSuasPublicacoes() {return;}
    
    public void addPublicacao(Publicacao p) {this.publicacoes.put(p.getNome(), p);}

    @Override
    public String toString() {
        return "------DOCENTE------"                              +
        "\nCod: "            + this.getCodigo()                   +
        "\nNome: "           + this.getNome()                     +
        "\nCoord: "          + this.getCoordenador()              +
        "\nData Nasc: "      + this.getDataNascimento().getTime() +
        "\nData Ingresso: "  + this.getDataIngresso().getTime();
    }
    public void printPublicacoes() {
        for (String p: publicacoes.keySet()){
            String value = this.publicacoes.get(p).toString();  
            System.out.println("KEY: " + p + "\n" + value);  
        }
    }

    public int compareDoc(Docente doc) {return this.getNome().compareDoc(doc.getNome());}

    public static Comparator<Docente> ComparadorD = new Comparator<Docente>() {
        public int compare(Docente doc1, Docente doc2) {return doc1.compareDoc(doc2);}
    };
}