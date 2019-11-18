package PRPPG;

public class Veiculo {
    //ATRIBUTOS
    public char tipo;
    public String nome;
    public String issn;
    public String sigla;
    public float fatorImpacto;
    //METODOS
    // constructor
    public Veiculo(char tipo, String nome, String issn, String sigla, float fatorImpacto) {
    	super();
    	this.tipo = tipo;
    	this.nome = nome;
    	this.issn = issn;
    	this.sigla = sigla;
    	this.fatorImpacto = fatorImpacto;
    }
    // setters
    public void setTipo(char tipo) {this.tipo = tipo;}
	public void setNome(String nome) {this.nome = nome;}
    public void setIssn(String issn) {this.issn = issn;}
    public void setSigla(String sigla) {this.sigla = sigla;}
    public void setFatorImpacto(float fatI) {this.fatorImpacto = fatI;}
    // getters
    public char getTipo() {return this.tipo;}
    public String getNome() {return this.nome;}
    public String getIssn() {return this.issn;}
    public String getSigla() {return this.sigla;}
    public float getFatorImpacto() {return this.fatorImpacto;}
}