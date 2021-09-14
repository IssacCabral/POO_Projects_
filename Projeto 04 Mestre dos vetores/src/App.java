import models.MagicArray;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MagicArray magicArray = new MagicArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] tokens = scanner.nextLine().split(" ");

            try {
                if (tokens[0].equals("end")) {
                    break;
                }else if(tokens[0].equals("show")) {
                    System.out.println(magicArray);
                }else if(tokens[0].equals("add")) {
                    for(int i = 1; i < tokens.length; i++) {
                        magicArray.add(Integer.parseInt(tokens[i]));
                    }
                }else if(tokens[0].equals("get")) {
                    System.out.println(magicArray.getInd(Integer.parseInt(tokens[1])));
                }else if(tokens[0].equals("set")){
                    magicArray.setInd(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("rshow")){
                    magicArray.rShow();
                }else if(tokens[0].equals("find")){
                    int[] values = new int[tokens.length];
                    for(int i = 1; i < tokens.length; i++){
                        values[i] = Integer.parseInt(tokens[i]);
                    }
                    magicArray.findElement(values);
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}
