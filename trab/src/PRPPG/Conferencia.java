package PRPPG;

public class Conferencia extends Veiculo {
    //METODOS
	// constructor
	public Conferencia(char tipo, String nome, String sigla, float fatorImpacto) {
        super(tipo, nome, sigla, fatorImpacto);
	}

	@Override
    public String toString() {
        String str = "------CONFERENCIA------"               +
        "\nTipo: "              + this.getTipo()         +
        "\nNome: "              + this.getNome()         +
        "\nSigla: "             + this.getSigla()        +
        "\nFator de impacto: "  + this.getFatorImpacto();
        return str;
    }
}