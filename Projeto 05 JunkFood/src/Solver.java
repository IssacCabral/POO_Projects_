import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maquina = null;

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            try{
                if(tokens[0].equals("init")){
                    maquina = new Maquina(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("show")){
                    System.out.println(maquina);
                }else if(tokens[0].equals("set")){
                    maquina.alterarEspiral(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]),
                            Float.parseFloat(tokens[4]));
                }else if(tokens[0].equals("limpar")){
                    maquina.limparEspiral(Integer.parseInt(tokens[1]));
                }else if(tokens[0].equals("dinheiro")){
                    maquina.inserirDinheiro(Float.parseFloat(tokens[1]));
                }else if (tokens[0].equals("comprar")){
                    maquina.comprar(Integer.parseInt(tokens[1]));
                }else if(tokens[0].equals("end")){
                    return;
                }else if(tokens[0].equals("troco")){
                    maquina.troco();
                }else{
                    System.out.println("Fail: comando inválido");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
