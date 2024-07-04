public class Barbeiro extends Thread {
    private final Barbearia barbearia;
    private boolean ativo;

    public Barbeiro(Barbearia barbearia) {
        this.barbearia = barbearia;
        this.ativo = true;
    }

    //condição de término do loop abaixo
    public void parar() {
        this.ativo = false;
        this.interrupt(); //aqui acabo por interromper a thread se estiver aguardando
    }



    @Override
    public void run() {
        try {
            while (ativo) {
                Cliente cliente = barbearia.pegaProximoCliente();
                atenderCliente(cliente);
            }
        } catch (InterruptedException e) {
            System.out.println("barbeiro interrompido.");
        }
    }

    private void atenderCliente(Cliente cliente) {
        System.out.println("atendendo o cliente " + cliente.getClienteId());
        try {
            Thread.sleep(2000); //simulando tempo de atendimento do cliente
        } catch (InterruptedException e) {
            System.out.println("atendimento interrompido.");
        }
        System.out.println("Cliente " + cliente.getClienteId() + " atendido.");
    }
}