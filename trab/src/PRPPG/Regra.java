package PRPPG;

import java.util.Calendar;

public class Regra {
    //ATRIBUTOS
	public int pontuacaoMin;
	public int anosConsiderados;
	public float multiplicador;
	public Calendar dataInicio;
	public Calendar dataFim;
    //METODOS
	// constructor
	public Regra(int pontuacaoMin, int anosConsiderados, float multiplicador, Calendar dataInicio, Calendar dataFim) {
		super();
		this.pontuacaoMin = pontuacaoMin;
		this.anosConsiderados = anosConsiderados;
		this.multiplicador = multiplicador;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
    // setters
	public void setPontuacaoMin(int pontuacaoMin) {this.pontuacaoMin = pontuacaoMin;}
	public void setAnosConsiderados(int anosConsiderados) {this.anosConsiderados = anosConsiderados;}
	public void setDataInicio(Calendar dataInicio) {this.dataInicio = dataInicio;}
	public void setDataFim(Calendar dataFim) {this.dataFim = dataFim;}

    // getters
	public int getPontuacaoMin() {return pontuacaoMin;}
	public int getAnosConsiderados() {return anosConsiderados;}
	public Calendar getDataInicio() {return dataInicio;}
	public Calendar getDataFim() {return dataFim;}
}