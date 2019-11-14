public class Publicacao {
    //ATRIBUTOS
    public String nome;
    public int codigo;
    public int anoPublicacao;

    //METODOS
    // seters
    public void setNome(String nome) {this.nome = nome;}
    public void setCodigo(int cod) {this.codigo = cod;}
    public void setAnoPublicacao(int anoP) {this.anoPublicacao = anoP;}
    // geters
    public String getNome() {return this.nome;}
    public int getCodigo() {return this.codigo;}
    public int getAnoPublicacao() {return this.anoPublicacao;}
}