public class Cozinha {
    public void prepararPedido(Pedido pedido) {
        System.out.println("Cozinha está preparando o pedido: " + pedido);
        pedido.setStatusPedido("Em preparo");
    }
}