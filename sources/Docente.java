public class Docente {
    public int codigo;
    public String nome;
    public Boll coordenador;		
    public Calendar dataNascimento;
    public Calendar dataIngresso;
    public HashMap<cod, Publicacao> Publicacoes;

    // METODOS
    // seters
    public void setCodigo(int cod) {this.codigo = cod;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCoordenador(Boll coord) {this.coordenador = coord;}
    public void setDataNascimento(Calendar dataN) {this.dataNascimento = dataN;}
    public void setDataIngresso(Calendar dataI) {this.dataIngresso = dataI;}
    // geters
    public int getCodigo() {return this.codigo;}
    public String getNome() {return this.nome;}
    public Boll getCoordenador() {return this.coordenador;}
    public Calendar getDataNascimento() {return this.dataNascimento;}
    public Calendar getDataIngresso() {return this.dataIngresso;}

    public quaisSaoSuasPublicacoes();
}