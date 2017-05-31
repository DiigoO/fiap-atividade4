package br.com.fiap.Atividade4.fiap.Atividade4.I;

import java.util.ArrayList;
import java.util.List;

public class Mensagens extends Thread{

    private List<String> msg = new ArrayList<>();

    private void sendMenssage(){
        msg.add("Oi");
        msg.add("ola");
        msg.add("sim");
        msg.add("nao");
        msg.add("otimo");
        msg.add("yes");
        msg.add("no");
        msg.add("ei");
        msg.add("ui");
        msg.add("yeah");
    }

    public void run() {
        sendMenssage();
        for(String e:msg){
            System.out.println(e);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        Thread.interrupted();
    }

}
