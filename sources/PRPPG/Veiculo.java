package PRPPG;

import java.util.HashMap;

public class Veiculo {
    //ATRIBUTOS
    public char tipo;
    public String nome;
    public String sigla;
    public float fatorImpacto;
    public HashMap<Integer,Qualis> qualis;
    //METODOS
    // constructor
    public Veiculo(char tipo, String nome, String sigla, float fatorImpacto) {
    	super();
    	this.tipo = tipo;
    	this.nome = nome;
    	this.sigla = sigla;
    	this.fatorImpacto = fatorImpacto;
    }
    // setters
    public void setTipo(char tipo) {this.tipo = tipo;}
	public void setNome(String nome) {this.nome = nome;}
    public void setSigla(String sigla) {this.sigla = sigla;}
    public void setFatorImpacto(float fatI) {this.fatorImpacto = fatI;}
    // getters
    public char getTipo() {return this.tipo;}
    public String getNome() {return this.nome;}
    public String getSigla() {return this.sigla;}
    public float getFatorImpacto() {return this.fatorImpacto;}

    public void addQualis(Qualis q) {this.qualis.put(q.getAno(), q);}
}