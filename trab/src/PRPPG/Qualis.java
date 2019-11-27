package PRPPG;

public class Qualis {
	//ATRIBUTOS
	public int ano;
	public double ponto;
	public String valor;
	//METODOS
    // constructor
	public Qualis(int ano, String valor) {
		super();
		this.ano = ano;
		this.valor = valor;
	}
	// setters
	private void setAno(int ano) {this.ano = ano;}
	private void setPonto(int ponto) {this.ponto = ponto;}
	private void setValor(String valor) {this.valor = valor;}
	// getters
	public int getAno() {return ano;}
	public double getPonto() {return ponto;}
	public String getValor() {return valor;}

	@Override
    public String toString() {
        String str = "------QUALIS------"   +
        "\nAno: "   + this.getAno()   		+
        "\nPonto: " + this.getPonto() 		+
        "\nValor: " + this.getValor();
    	return str;
    }
}