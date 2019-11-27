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
	private void setPontuacaoMin(int pontuacaoMin) {this.pontuacaoMin = pontuacaoMin;}
	private void setAnosConsiderados(int anosConsiderados) {this.anosConsiderados = anosConsiderados;}
	private void setMultiplicador(float mult) {this.multiplicador = mult;}
	private void setDataInicio(Calendar dataInicio) {this.dataInicio = dataInicio;}
	private void setDataFim(Calendar dataFim) {this.dataFim = dataFim;}

    // getters
	public int getPontuacaoMin() {return this.pontuacaoMin;}
	public int getAnosConsiderados() {return this.anosConsiderados;}
	public float getMultiplicador() {return this.multiplicador;}
	public Calendar getDataInicio() {return this.dataInicio;}
	public Calendar getDataFim() {return this.dataFim;}

	@Override
    public String toString() {
        String str = "------REGRA------" 				 	 +
        "\nPontMin: " 		+ this.getPontuacaoMin() 	 	 +
        "\nAnosCons: " 		+ this.getAnosConsiderados() 	 +
        "\nMult: " 			+ this.getMultiplicador() 	 	 +
        "\nData inicio: " 	+ this.getDataInicio().getTime() +
		"\nData fim: " 		+ this.getDataFim().getTime();
		return str;
    }
}