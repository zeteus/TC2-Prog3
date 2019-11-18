package PRPPG;

public class Qualis {
	//ATRIBUTOS
	public int ano;
	public double ponto;
	public String valor;
	//METODOS
    // constructor
	public Qualis(int ano, double ponto, String valor) {
		super();
		this.ano = ano;
		this.ponto = ponto;
		this.valor = valor;
	}
	// setters
	public void setAno(int ano) {this.ano = ano;}
	public void setPonto(int ponto) {this.ponto = ponto;}
	public void setValor(String valor) {this.valor = valor;}
	// getters
	public int getAno() {return ano;}
	public int getPonto() {return ponto;}
	public String getValor() {return valor;}
}