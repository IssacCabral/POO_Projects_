package models;
import java.util.ArrayList;
import java.util.List;

public class Trampoline {
    //Attributes
    private List<Kid> playing;
    private List<Kid> waiting;
    private double caixa;

    //Constructor
    public Trampoline(){
        this.playing = new ArrayList<>();
        this.waiting = new ArrayList<>();
    }

    //Methods
    public void arrive(Kid kid){
        this.waiting.add(0, kid);
    }

    public void in() throws Exception{
        //Lançando o erro pra cima//


        if(this.waiting.isEmpty()){
            throw new Exception("Não tem Ninguém na fila de espera");
        }

        Kid kid = waiting.get(waiting.size() - 1);
        this.playing.add(0,kid);
        this.waiting.remove(waiting.size() - 1);


        /*try{
            Kid kid = waiting.get(waiting.size() - 1);
            this.playing.add(0,kid);
            this.waiting.remove(waiting.size() - 1);
        }catch (RuntimeException e){
            System.out.println("Não tem ninguém na fila de espera Bro!!!");
        }*/

    }

    public void out() throws Exception{
        if(this.playing.isEmpty()){
            throw new Exception("Não tem ninguém na fila de Playing");
        }
        /* Remove a criança da última posição na fila do pula pula
           e a coloca na primeira posição da fila de espera */
        Kid kid = playing.get(playing.size() - 1);
        playing.remove(kid);
        waiting.add(0, kid);
    }

    //Remove do parquinhos
    public void remove(String name) throws Exception {
        for(Kid kid: waiting){
            if(kid.getName().equals(name)){
                waiting.remove(kid);
                return;
            }
        }
        for(Kid kid: playing){
            if(kid.getName().equals(name)){
                playing.remove(kid);
                return;
            }
        }

        throw new Exception("Nome não encontrado na lista");
    }

    public String toString(){
        return "=>" + this.waiting + "\n" + "=>" + this.playing + "\n"
                + "CAIXA: R$ " + this.caixa;
    }


}
