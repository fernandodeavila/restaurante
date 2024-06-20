import java.util.Queue;

public class Garcom extends Pessoa {
    public Garcom(String nome, String cpf) {
        super(nome, cpf);
    }

    public void registrarPedido(Pedido pedido) {
        System.out.println("Pedido registrado: " + pedido);
    }

    public void enviarPedidoCozinha(Pedido pedido, Queue<Pedido> filaPedidos) {
        filaPedidos.add(pedido);
        System.out.println("Pedido enviado para a cozinha: " + pedido);
    }

    public void informarConta(Cliente cliente, Conta conta) {
        System.out.println("Conta informada ao cliente: " + conta);
    }
}