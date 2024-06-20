public class Mesa {
    private boolean estaDisponivel;
    private int capacidade;

    public Mesa(boolean estaDisponivel, int capacidade) {
        this.estaDisponivel = estaDisponivel;
        this.capacidade = capacidade;
    }

    public boolean isDisponivel() {
        return estaDisponivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }
}