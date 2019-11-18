package PRPPG;

import java.util.Calendar;
import java.util.HashMap;

public class Docente {
    public int codigo;
    public String nome;
    public boolean coordenador;		
    public Calendar dataNascimento;
    public Calendar dataIngresso;
    public HashMap<Integer, Publicacao> Publicacoes;

    // METODOS
    // constructor
    public Docente(int codigo, String nome, boolean coordenador, Calendar dataNascimento, Calendar dataIngresso) {
    	super();
    	this.codigo = codigo;
    	this.nome = nome;
    	this.coordenador = coordenador;
    	this.dataNascimento = dataNascimento;
    	this.dataIngresso = dataIngresso;
    }
	// setters
    public void setCodigo(int cod) {this.codigo = cod;}
	public void setNome(String nome) {this.nome = nome;}
    public void setCoordenador(boolean coord) {this.coordenador = coord;}
    public void setDataNascimento(Calendar dataN) {this.dataNascimento = dataN;}
    public void setDataIngresso(Calendar dataI) {this.dataIngresso = dataI;}
    // getters
    public int getCodigo() {return this.codigo;}
    public String getNome() {return this.nome;}
    public boolean getCoordenador() {return this.coordenador;}
    public Calendar getDataNascimento() {return this.dataNascimento;}
    public Calendar getDataIngresso() {return this.dataIngresso;}

    public void quaisSaoSuasPublicacoes() {
    	return;
    }
}