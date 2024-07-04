import java.util.ArrayList;
import java.util.List;

public class Barbearia {
    private final int numeroDeCadeiras;
    private final List<Thread> cadeiras;

    //construtor
    public Barbearia(int numeroDeCadeiras) {
        this.numeroDeCadeiras = numeroDeCadeiras;
        this.cadeiras = new ArrayList<>(numeroDeCadeiras);
    }

    //permitindo que um cliente entre na sala de espera
    public synchronized boolean entraNaSalaDeEspera(Cliente cliente) {
        //verificando se há cadeiras disponíveis
        if (cadeiras.size() < numeroDeCadeiras) {
            cadeiras.add(cliente);
            System.out.println("Cliente " + cliente.getClienteId() + " está esperando.");
            notifyAll(); // notifica o barbeiro que o cliente tá resperando
            return true;
        } else {
            System.out.println("Cliente " + cliente.getClienteId() + " desistiu. Sala de espera tá cheia.");
            return false;
        }
    }

    //barbeiro pega proximo cliente pra atendimento
    public synchronized Cliente pegaProximoCliente() throws InterruptedException {
        //loop que continua enquanto nao houver clientes esperando, pq o barbeiro dorme
        while (cadeiras.isEmpty()) {
            System.out.println("barbeiro tá tirando uma sonequinha...");
            wait(); // faz a thread do barbeiro esperr até que um cliente apareça
        }
        Cliente cliente = (Cliente) cadeiras.remove(0); //remove e retorna o primeiro cliente da lista de cadeiras
        System.out.println("O barbeiro tá atendendo o cliente " + cliente.getClienteId());
        return cliente;
    }
}