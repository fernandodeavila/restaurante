import java.util.List;

public class Recepcao {
    public void verificarMesaDisponivel(List<Mesa> mesas, int numPessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.isDisponivel() && mesa.getCapacidade() >= numPessoas) {
                mesa.setDisponivel(false);
                System.out.println("Mesa disponível para " + numPessoas + " pessoas.");
                return;
            }
        }
        System.out.println("Não há mesas disponíveis para " + numPessoas + " pessoas. Por favor, aguarde.");
    }
}