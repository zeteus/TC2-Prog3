package PRPPG;

public class Publicacao {
    //ATRIBUTOS
    public String nome;
    public String volumeLocal;
    public int numero;
    public int anoPublicacao;
    public int pagInicial;
    public int pagFinal;
    //METODOS
    // constructor
    public Publicacao(String nome, int numero, int anoPublicacao, int pagInicial, int pagFinal) {
    	super();
    	this.nome = nome;
    	this.numero = numero;
        this.anoPublicacao = anoPublicacao;
        this.pagInicial = pagInicial;
        this.pagFinal = pagFinal;
    }
    // setters
    public void setVolumeLocal(String vl) {this.volumeLocal = vl;}
    private void setNome(String nome) {this.nome = nome;}
	private void setNumero(int cod) {this.numero = cod;}
    private void setAnoPublicacao(int anoP) {this.anoPublicacao = anoP;}
    private void setPagInicial(int pagI) {this.pagInicial = pagI;}
    private void setPagFinal(int pagF) {this.pagFinal = pagF;}
    // getters
    public String getNome() {return this.nome;}
    public String getVolumeLocal() {return this.volumeLocal;}
    public int getNumero() {return this.numero;}
    public int getAnoPublicacao() {return this.anoPublicacao;}
    public int getPagInicial() {return this.pagInicial;}
    public int getPagFinal() {return this.pagFinal;}

    @Override
    public String toString() {
        String str = "------PUUBLICACAO------" 		    +
        "\nNome: " 	         + this.getNome() 	        +
        "\nVolumeLocal: " 	 + this.getVolumeLocal()    +
        "\nNumero: " 		 + this.getNumero() 	    +
        "\nAno Publicacao: " + this.getAnoPublicacao()  +
        "\nPagI: "  	     + this.getPagInicial()     +
        "\nPagF: " 	         + this.getPagFinal();
		return str;
    }
}