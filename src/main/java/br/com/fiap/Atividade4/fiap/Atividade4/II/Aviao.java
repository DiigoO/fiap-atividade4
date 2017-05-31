package br.com.fiap.Atividade4.fiap.Atividade4.II;

public class Aviao extends Thread{

    private String nomeVoo;
    private Aeroporto airport;

    public Aviao(String nomeVoo, Aeroporto airport) {
        super();
        this.nomeVoo = nomeVoo;
        this.airport = airport;
    }

    public void voar(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decoloar() {
        boolean result = airport.aguardarPistaDisponivel();
        if (result) {
            System.out.println("Pode Decolar, pista livre!");
        }
    }

    public void aterrissar(){
        boolean result = airport.aguardarPistaDisponivel();
        if(result){
            System.out.println("Pode aterrissar, pista livre!");
        }
    }

}
