public class Alimento {
    private String nome;
    private String tipo;
    private double quantidade;

    public Alimento(String nome, String tipo, double quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }
}
