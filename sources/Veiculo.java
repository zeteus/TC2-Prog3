public class Veiculo {
    //ATRIBUTOS
    public char tipo;
    public String nome;
    public String issn;
    public String sigla;
    public String fatorImpacto;
    //METODOS
    // seters
    public void setTipo(char tipo) {this.tipo = tipo;}
    public void setNome(String nome) {this.nome = nome;}
    public void setIssn(String issn) {this.issn = issn;}
    public void setSigla(String sigla) {this.sigla = sigla;}
    public void setFatorImpacto(char FI) {this.fatorImpacto = FI;}
    // geters
    public char getTipo() {return this.tipo;}
    public String getNome() {return this.nome;}
    public String getIssn() {return this.issn;}
    public String getSigla() {return this.sigla;}
    public String getFatorImpacto() {return this.fatorImpacto;}
} 