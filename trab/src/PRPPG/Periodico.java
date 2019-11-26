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

    // getters
}