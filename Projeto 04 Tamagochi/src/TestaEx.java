import java.util.Scanner;

public class TestaEx {

    double dividir(int a, int b) throws Exception {
        if(b == 0){
            throw new Exception("Impossível dividir por zero");
        }
        return (double)a/b;
    }
    double maiorResultado(int a, int b, int c, int d) throws Exception {
        double x = dividir(a,b);
        double y = dividir(b,c);
        return x > y ? x: y;
    }
    public void main(String[] args) {
        int a,b,c,d;
        System.out.println("Digite 4 inteiros");
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        try{
            double result = this.maiorResultado(a,b,c,d);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
