public class Calculator {
    private int batteryMax;
    private int baterry;
    private float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
    }

    public void chargeBattery(int charge){
        if(charge <= 0){
            System.out.println("Valor inválido");
            return;
        }
        if(charge >= batteryMax){
            baterry = batteryMax;
        }else{
            baterry += charge;
            if(baterry > batteryMax){
                baterry = batteryMax;
            }
        }
    }

    public void division(int num1, int num2){
        if(num2 == 0){
            System.out.println("Impossível dividir por zero!");
            return;
        }
        display = num1/num2;
    }

    public void sum(int num1, int num2){
        display = num1+num2;
    }

    public String toString(){
        String saida = "Display = " + display + ", " + "Battery = " + baterry;
        return saida;
    }
}
