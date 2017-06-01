# fiap-atividade4

ARRUMAR DEPOIS

I.
 
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
 
Mensagens t = new Mensagens();
t.start();
Data d = new Data();
d.start();
 
while (true){
    try {
        Thread.sleep(5000);
        System.out.println("Thread Menssagens estado: "+t.getState());
        System.out.println("Thread Data estado: "+d.getState());
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
 
 
II.
public class Aeroporto extends Thread {
 
    private String nomeAeroporto;
    private boolean pistaLiberada = false;
 
    public Aeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }
 
    synchronized void pistaDisponivel(Aviao t, String acao) throws InterruptedException {
        if (!pistaLiberada) {
            System.out.println(t.getNomeVoo() + " Esperando para " + acao + "...");
            this.wait();
        }
    }
 
    synchronized void alterarEstadoPista() {
        // pistaLiberada = new Random().nextBoolean();
        pistaLiberada = true;
        if (pistaLiberada)
            this.notifyAll();
    }
 
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            alterarEstadoPista();
            run();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
 
public class Aviao extends Thread {
 
    private String nomeVoo;
    private Aeroporto airport;
 
    public Aviao(String nomeVoo, Aeroporto airport) {
        super();
        this.nomeVoo = nomeVoo;
        this.airport = airport;
    }
 
    synchronized void voar() {
        try {
            Thread.sleep(2000);
            System.out.println(this.nomeVoo + " voando...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    synchronized void decolar() throws InterruptedException {
        airport.pistaDisponivel(this, "decolar");
        System.out.println(this.nomeVoo + " Decolando...");
    }
 
    synchronized void aterrissar() throws InterruptedException {
        airport.pistaDisponivel(this, "aterrisar");
        System.out.println(this.nomeVoo + " Aterrisando...!");
    }
   
    public String getNomeVoo() {
        return this.nomeVoo;
    }
 
    @Override
    public void run() {
        try {
            decolar();
            voar();
            aterrissar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
 
Aeroporto a = new Aeroporto("Guarulhos");
Aviao aviaoTan = new Aviao("TAN 123", a);
Aviao aviaoOLE = new Aviao("OLÉ 11", a);
Aviao aviaoLinha = new Aviao("LINHA 22", a);
 
a.start();
aviaoTan.start();
aviaoOLE.start();
aviaoLinha.start();
 
 
III.
 
 
public enum Cores {
    BRANCO("Branco", 21), PRETO("Preto", 22), VERMELHO("Vermelho", 23), AMARELO("Amarelo", 24), AZUL("Azul", 25);
   
    private String nomeCor;
    private int codigoCor;
   
    private Cores(String nomeCor, int codigoCor) {
        this.nomeCor = nomeCor;
        this.codigoCor = codigoCor;
    }
   
    public String getNomeCor() {
        return this.nomeCor;
    }
   
    public int getCodigoCor() {
        return this.codigoCor;
    }
   
   
}
 
public static void main(String[] args) {
    JTable table = null;
    Object[] cols = { "Cor", "Código" };
    DefaultTableModel tableModel = new DefaultTableModel(cols, 0);
 
    for (Cores c : Cores.values()) {
        List<String> valores = new ArrayList<>();
        valores.add(c.getNomeCor());
        valores.add(String.valueOf(c.getCodigoCor()));
 
        tableModel.addRow(Arrays.asList(c.getNomeCor(), String.valueOf(c.getCodigoCor())).toArray());
    }
 
    table = new JTable(tableModel);
 
    JOptionPane.showMessageDialog(null, new JScrollPane(table));
 
    JOptionPane.showMessageDialog(null, "Código da cor branca: " + Cores.BRANCO.getCodigoCor());
}
