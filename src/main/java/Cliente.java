import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private int qtdAcompanhantes;
    private List<Pedido> historicoPedidos;

    public Cliente(String nome, String cpf, int qtdAcompanhantes) {
        super(nome, cpf);
        this.qtdAcompanhantes = qtdAcompanhantes;
        this.historicoPedidos = new ArrayList<>();
    }

    public int getQtdAcompanhantes() {
        return qtdAcompanhantes;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        historicoPedidos.add(pedido);
    }
}