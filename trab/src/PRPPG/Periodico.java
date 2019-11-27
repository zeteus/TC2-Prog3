package PRPPG;

public class Periodico extends Veiculo {


	//ATRIBUTOS
    public String issn;
    //METODOS
	// constructor
    public Periodico(char tipo, String nome, String issn, String sigla, float fatorImpacto) {
    	super(tipo, nome, sigla, fatorImpacto);
    	this.issn = issn;
    }
    // setters
    private void setIssn(String issn) {this.issn = issn;}
    // getters
    public String getIssn() {return this.issn;}

    @Override
    public String toString() {
        String str = "------PERIODICO------"             +
        "\nTipo: "              + this.getTipo()         +
        "\nNome: "              + this.getNome()         +
        "\nSigla: "             + this.getSigla()        +
        "\nISSN: "              + this.getIssn()         +
        "\nFator de impacto: "  + this.getFatorImpacto();
        return str;
    }
}