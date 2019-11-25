package PRPPG;

public class Publicacao {
    //ATRIBUTOS
    public String nome;
    public int codigo;
    public int anoPublicacao;
    //METODOS
    // constructor
    public Publicacao(String nome, int codigo, int anoPublicacao) {
    	super();
    	this.nome = nome;
    	this.codigo = codigo;
    	this.anoPublicacao = anoPublicacao;
    }
    // setters
    public void setNome(String nome) {this.nome = nome;}
	public void setCodigo(int cod) {this.codigo = cod;}
    public void setAnoPublicacao(int anoP) {this.anoPublicacao = anoP;}
    // getters
    public String getNome() {return this.nome;}
    public int getCodigo() {return this.codigo;}
    public int getAnoPublicacao() {return this.anoPublicacao;}
}