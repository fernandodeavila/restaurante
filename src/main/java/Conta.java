public class Conta {
    private double totalConta;
    private String status;
    private String detalhes;

    public Conta(double totalConta, String status, String detalhes) {
        this.totalConta = totalConta;
        this.status = status;
        this.detalhes = detalhes;
    }

    public double getTotalConta() {
        return totalConta;
    }

    public String getStatus() {
        return status;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void calcularTotal(Pedido pedido) {
        this.totalConta = pedido.getListaPratos().stream().mapToDouble(Prato::getValor).sum();
        this.detalhes = "Conta para o pedido " + pedido.getId() + ": " + pedido.getListaPratos();
    }

    @Override
    public String toString() {
        return "Conta{" +
                "totalConta=" + totalConta +
                ", status='" + status + '\'' +
                ", detalhes='" + detalhes + '\'' +
                '}';
    }
}