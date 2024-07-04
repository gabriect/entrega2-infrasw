public class Cliente extends Thread {
    private final int clienteId;
    private final Barbearia barbearia;

    public Cliente(int clienteId, Barbearia barbearia) {
        this.clienteId = clienteId;
        this.barbearia = barbearia;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public void run() {
        if (barbearia.entraNaSalaDeEspera(this)) {
            try {
                Thread.sleep(1000); //espera um tempo antes de tentar novamente
            } catch (InterruptedException e) {
                System.out.println("Cliente " + clienteId + " interrompido.");
            }
        }
    }
}