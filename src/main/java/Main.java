import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      List<Mesa> mesas = new ArrayList<Mesa>();
      List<Prato> pratos = new ArrayList<Prato>();
      Queue<Pedido> filaPedidos = new LinkedList<Pedido>();
      Cozinha cozinha = new Cozinha();
      Recepcao recepcao = new Recepcao();
      Garcom garcom = new Garcom("Carlos", "98765432100");

      // Adicionando mesas ao restaurante
      mesas.add(new Mesa(true, 4));
      mesas.add(new Mesa(true, 2));
      mesas.add(new Mesa(true, 6));

      // Adicionando pratos ao cardápio
      pratos.add(new Prato("Pizza", "Pizza de mussarela", 30.0, 10, "Principal", 20));
      pratos.add(new Prato("Salada", "Salada Caesar", 15.0, 5, "Entrada", 10));
      pratos.add(new Prato("Cerveja", "Cerveja artesanal", 10.0, 20, "Bebida", 5));
      pratos.add(new Prato("Sorvete", "Sorvete de chocolate", 12.0, 15, "Sobremesa", 7));

      System.out.println("Bem-vindo ao restaurante!");
      System.out.print("Informe seu nome: ");
      String nome = scanner.nextLine();
      System.out.print("Informe seu CPF: ");
      String cpf = scanner.nextLine();
      System.out.print("Informe a quantidade de acompanhantes: ");
      int qtdAcompanhantes = scanner.nextInt();
      scanner.nextLine(); // Consumir a linha nova

      Cliente cliente = new Cliente(nome, cpf, qtdAcompanhantes);
      recepcao.verificarMesaDisponivel(mesas, qtdAcompanhantes + 1);

      boolean running = true;

      while (running) {
          System.out.println("Menu de Opções:");
          System.out.println("1. Ver Cardápio");
          System.out.println("2. Fazer Pedido");
          System.out.println("3. Consultar Status do Pedido");
          System.out.println("4. Fechar Conta");
          System.out.println("5. Sair");
          System.out.print("Selecione uma opção: ");
          int opcao = scanner.nextInt();
          scanner.nextLine(); // Consumir a linha nova

          switch (opcao) {
              case 1:
                  System.out.println("Cardápio:");
                  for (int i = 0; i < pratos.size(); i++) {
                      System.out.println((i + 1) + ". " + pratos.get(i));
                  }
                  break;
              case 2:
                  System.out.println("Informe o número do prato que deseja pedir: ");
                  int pratoIndex = scanner.nextInt();
                  List<Prato> pratosPedido = new ArrayList<>();
                  pratosPedido.add(pratos.get(pratoIndex - 1));

                  Pedido pedido = new Pedido(filaPedidos.size() + 1, cliente, pratosPedido);
                  cliente.adicionarPedido(pedido);

                  garcom.registrarPedido(pedido);
                  garcom.enviarPedidoCozinha(pedido, filaPedidos);
                  cozinha.prepararPedido(pedido);

                  System.out.println("Seu pedido foi adicionado à fila. Tempo estimado: " + pedido.getTempoPreparoPedido() + " minutos.");
                  break;
              case 3:
                  if (filaPedidos.isEmpty()) {
                      System.out.println("Você não tem pedidos registrados.");
                  } else {
                      System.out.println("Fila de Pedidos:");
                      int tempoTotal = 0;
                      for (Pedido p : filaPedidos) {
                          tempoTotal += p.getTempoPreparoPedido();
                          System.out.println("Pedido " + p.getId() + ": " + p.getStatusPedido() + " - Tempo restante: " + tempoTotal + " minutos");
                      }
                  }
                  break;
              case 4:
                  if (cliente.getHistoricoPedidos().isEmpty()) {
                      System.out.println("Você não tem pedidos registrados.");
                  } else {
                      Pedido ultimoPedido = cliente.getHistoricoPedidos().get(cliente.getHistoricoPedidos().size() - 1);
                      Conta conta = new Conta(0, "Pendente", "");
                      conta.calcularTotal(ultimoPedido);
                      garcom.informarConta(cliente, conta);

                      System.out.println("Total da conta: R$" + conta.getTotalConta());
                      System.out.println("Detalhes: " + conta.getDetalhes());

                      System.out.println("Forma de pagamento: (1 - Dinheiro, 2 - Cartão)");
                      int formaPagamento = scanner.nextInt();
                      if (formaPagamento == 1) {
                          conta.setStatus("Pago em dinheiro");
                      } else {
                          conta.setStatus("Pago com cartão");
                      }

                      System.out.println("Pagamento realizado com sucesso. Obrigado por visitar nosso restaurante!");
                  }
                  break;
              case 5:
                  running = false;
                  System.out.println("Saindo... Obrigado por visitar nosso restaurante!");
                  break;
              default:
                  System.out.println("Opção inválida. Por favor, tente novamente.");
                  break;
          }
      }

      scanner.close();
  }

}