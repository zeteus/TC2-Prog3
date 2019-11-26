package PRPPG;

public class Publicacao {
    //ATRIBUTOS
    public String nome;
    public int numero;
    public int anoPublicacao;
    //METODOS
    // constructor
    public Publicacao(String nome, int numero, int anoPublicacao) {
    	super();
    	this.nome = nome;
    	this.numero = numero;
        this.anoPublicacao = anoPublicacao;
    }
    // setters
    public void setNome(String nome) {this.nome = nome;}
	public void setNumero(int cod) {this.numero = cod;}
    public void setAnoPublicacao(int anoP) {this.anoPublicacao = anoP;}
    // getters
    public String getNome() {return this.nome;}
    public int getNumero() {return this.numero;}
    public int getAnoPublicacao() {return this.anoPublicacao;}
}