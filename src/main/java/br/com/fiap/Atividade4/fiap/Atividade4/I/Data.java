package br.com.fiap.Atividade4.fiap.Atividade4.I;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data extends Thread{

    LocalDateTime date;


    private void showDate(){
        date = LocalDateTime.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public void run() {
        while (true) {
            showDate();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
