package seinao;

import java.util.Scanner;

class Calculator {
    int bateria;

    public Calculator() {
        this.bateria = 0;
    }

    void gastar_bateria() {
        if (bateria == 0) {
            throw new RuntimeException("bateria acabou");
        }
        bateria -= 1;
    }

    int soma(int a, int b) {
        gastar_bateria();
        return a + b;
    }

    double div(int a, int b) {
        return (double) a / b;
    }

    void recarregar(int value) {
        this.bateria += value;
    }
}

public class SeiNao {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");

                if (tokens[0].equals("end")) {
                    break;
                } else if (tokens[0].equals("charge")) {
                    calculator.recarregar(Integer.parseInt(tokens[1]));
                } else if (tokens[0].equals("sum")) {
                    int value = calculator.soma(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    System.out.println(value);
                } else {
                    System.out.println("fail: comando inválido");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("fail: provavelmente esqueceu algum parametro " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}


