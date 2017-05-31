package br.com.fiap.Atividade4.fiap.Atividade4.II;

import java.util.Random;

public class Aeroporto extends Thread {

    private String nomeAeroporto;
    private boolean estadoPista = true;

    public Aeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public boolean aguardarPistaDisponivel(){
        if (estadoPista){
            return true;
        }else{
            aguardarPistaDisponivel();
        }
        return false;
    }

    public void alterarEstadoPista(){
        try {
            Thread.sleep(3000);
            Random random = new Random();
            estadoPista = random.nextBoolean();
            alterarEstadoPista();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
