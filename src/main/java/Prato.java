public class Prato {
    private String nome;
    private String descricao;
    private double valor;
    private int qtd;
    private String tipo; // Alterado de categoria para tipo
    private int tempoPreparo;

    public Prato(String nome, String descricao, double valor, int qtd, String tipo, int tempoPreparo) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtd = qtd;
        this.tipo = tipo;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getQtd() {
        return qtd;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    @Override
    public String toString() {
        return nome + " (" + descricao + ") - R$" + valor;
    }
}