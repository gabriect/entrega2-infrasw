public class Main {
    public static void main(String[] args) {
        Barbearia barbearia = new Barbearia(6); // barbearia com 6 cadeiras de espera
        Barbeiro barbeiro = new Barbeiro(barbearia);
        barbeiro.start();

        for (int i = 0; i < 100; i++) {
            Cliente cliente = new Cliente(i, barbearia);
            cliente.start();
            try {
                Thread.sleep(1000); // 1s entre a chegada dos clietnes
            } catch (InterruptedException e) {
                System.out.println("Simulação interrompida.");
            }
        }


        try {

            Thread.sleep(10000); //esperando o tempo para atender os clientes
        } catch (InterruptedException e) {
            System.out.println("Simulação interrompida.");

        }

        //parando o barbeiro
        barbeiro.parar();
    }
}
