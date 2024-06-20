import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Prato> listaPratos;
    private String statusPedido;
    private int tempoPreparoPedido;

    public Pedido(int id, Cliente cliente, List<Prato> listaPratos) {
        this.id = id;
        this.cliente = cliente;
        this.listaPratos = listaPratos;
        this.statusPedido = "Pendente";
        this.tempoPreparoPedido = listaPratos.stream().mapToInt(Prato::getTempoPreparo).sum();
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Prato> getListaPratos() {
        return listaPratos;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public int getTempoPreparoPedido() {
        return tempoPreparoPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", listaPratos=" + listaPratos +
                ", statusPedido='" + statusPedido + '\'' +
                ", tempoPreparoPedido=" + tempoPreparoPedido +
                '}';
    }
}