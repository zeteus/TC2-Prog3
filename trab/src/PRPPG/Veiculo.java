package PRPPG;

import java.util.HashMap;

public class Veiculo {
    //ATRIBUTOS
    public char tipo;
    public String nome;
    public String sigla;
    public float fatorImpacto;
    public HashMap<Integer,Qualis> qualis;
    public HashMap<String,Publicacao> publicacoes;
    //METODOS
    // constructor
    public Veiculo(char tipo, String nome, String sigla, float fatorImpacto) {
    	super();
    	this.tipo = tipo;
    	this.nome = nome;
    	this.sigla = sigla;
        this.fatorImpacto = fatorImpacto;
        this.qualis = new HashMap<Integer, Qualis>();
        this.publicacoes = new HashMap<String, Publicacao>();
    }
    // setters
    private void setTipo(char tipo) {this.tipo = tipo;}
	private void setNome(String nome) {this.nome = nome;}
    private void setSigla(String sigla) {this.sigla = sigla;}
    private void setFatorImpacto(float fatI) {this.fatorImpacto = fatI;}
    // getters
    public char getTipo() {return this.tipo;}
    public String getNome() {return this.nome;}
    public String getSigla() {return this.sigla;}
    public float getFatorImpacto() {return this.fatorImpacto;}

    @Override
    public String toString() {
        String str = "------VEICULO------"               +
        "\nTipo: "              + this.getTipo()         +
        "\nNome: "              + this.getNome()         +
        "\nSigla: "             + this.getSigla()        +
        "\nFator de impacto: "  + this.getFatorImpacto();
        return str;
    }
    public void printQualis() {
        for (Integer q: qualis.keySet()){
            String key = q.toString();
            String value = this.qualis.get(q).toString(); 
            System.out.println("KEY: " + key + "\n" + value);  
        }
    }
    public void printPublicacoes() {
        for (String p: publicacoes.keySet()){
            String value = this.publicacoes.get(p).toString();  
            System.out.println("KEY: " + p + "\n" + value);  
        }
    }
    public void addQualis(Qualis q) {this.qualis.put(q.getAno(), q);}
    public void addPublicacao(Publicacao p) {this.publicacoes.put(p.getNome(), p);}
}