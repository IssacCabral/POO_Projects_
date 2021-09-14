public class Motorcycle {
    private Person person;
    private int power;
    private int time;

    public Motorcycle(int power){
        this.power = power;
    }

    public void buy(int time){
        if(time <= 0){
            System.out.println("Fail: valor inválido");
            return;
        }
        this.time += time;
    }

    public boolean in(Person person){
        if(this.person != null){
            System.out.println("Já tem gente na moto");
            return false;
        }

        this.person = person;
        return true;
    }

    public void out(){
        if(this.person == null){
            System.out.println("Não tem ninguém para descer");
            return;
        }
        person = null;
    }

    public void drive(int time){
        if(this.person.getAge() > 10){
            System.out.println("Fail: muito grande pra andar de moto");
            return;
        }
        if(this.time == 0){
            System.out.println("Fail: sem tempo para andar!");
            return;
        }
        //Acabou o Tempo, end of the time
        if(this.time - time < 0){
            System.out.println("Fail: andou " + this.time + " e acabou o tempo");
            this.time = 0;
        }else if(this.time - time == 0){
            this.time = 0;
        }else{
            this.time -= time;
        }
    }

    public void honk(){
        /*if(person == null){
            System.out.println("Moto vazia para buzinar");
            return;
        }
        String pem = "P";
        String aux = "";
        for(int i = 0; i < power; i++){
            aux += "e";
        }
        pem += aux;
        pem += "m";

        System.out.println(pem);*/

        StringBuilder sb = new StringBuilder();
        sb.append("Mateus");
    }

    @Override
    public String toString(){
        String exit;
        exit = "Potência: " + this.power + ", " +
                "Minutos: " + this.time + ", " +
                "Pessoa: " + this.person;
        return exit;
    }
}
