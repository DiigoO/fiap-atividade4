package br.com.fiap.Atividade4.fiap;

import br.com.fiap.Atividade4.fiap.Atividade4.II.Aviao;

public class Atividade04 {
    public static void main(String[] args) {
//        Mensagens t = new Mensagens();
//        t.start();
//        Data d = new Data();
//        d.start();
//
//        while (true){
//            try {
//                Thread.sleep(5000);
//                System.out.println("Thread Menssagens estado: "+t.getState());
//                System.out.println("Thread Data estado: "+d.getState());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        Aviao aviaoTan = new Aviao("TAN 123");
        Aviao aviaoOLE = new Aviao("OLÉ 11");
        Aviao aviaoLinha = new Aviao("LINHA 22");

        aviaoLinha.decoloar();
        aviaoOLE.aterrissar();
        aviaoTan.voar();


    }
}
