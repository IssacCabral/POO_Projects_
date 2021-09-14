package models;

public class Pet {
    //Max quantity elements --> Constants
    private final int CLEANING_MAX, ENERGY_MAX, SATIETY_MAX;

    //Attributes
    private int energy, satiety, cleaning;
    private int age;
    private int diamonds;
    private boolean alive;

    //Constructor
    public Pet(int energyMax, int satietyMax, int cleaningMax){
        this.ENERGY_MAX = energyMax;
        this.CLEANING_MAX = cleaningMax;
        this.SATIETY_MAX = satietyMax;

        this.energy = energyMax;
        this.satiety = satietyMax;
        this.cleaning = cleaningMax;
        this.age = 0;
        this.diamonds = 0;
        this.alive = true;
    }

    //Getters methods
    public int getCLEANING_MAX() {return CLEANING_MAX;}
    public int getENERGY_MAX() {return ENERGY_MAX;}
    public int getSATIETY_MAX() {return SATIETY_MAX;}
    public int getEnergy() {return energy;}
    public int getSatiety() {return satiety;}
    public int getCleaning() {return cleaning;}
    public int getAge() {return age;}
    public int getDiamonds() {return diamonds;}

    //Set methods
    private void setEnergy(int value){
        this.energy += value;

        if(this.getEnergy() > this.ENERGY_MAX){
            this.energy = this.getENERGY_MAX();
        }

        if(this.getEnergy() < 0){
            this.energy = 0;
            this.alive = false;
            System.out.println("Fail: O pet morreu sem energia!");
        }
    }

    private void setSatiety(int value){
        this.satiety += value;

        if(this.getSatiety() > this.getSATIETY_MAX()){
            this.satiety = this.getSATIETY_MAX();
        }

        if(this.getSatiety() < 0){
            this.satiety = 0;
            this.alive = false;
            System.out.println("Fail: O pet morreu fraquinho");
        }
    }

    private void setCleaning(int value){
        this.cleaning += value;

        if(this.getCleaning() > this.getCLEANING_MAX()){
            this.cleaning = this.getCLEANING_MAX();
        }

        if(this.getCleaning() < 0){
            this.cleaning = 0;
            this.alive = false;
            System.out.println("Fail: O pet morreu de sujeira");
        }
    }

    //O comando "$play" altera em -2 energia, -1 saciedade, -3 limpeza, +1 diamante, +1 idade.
    public void play(){
        if(!this.alive){
            System.out.println("Fail: O pet está morto");
            return;
        }

        this.setCleaning(-3);
        this.setEnergy(-2);
        this.setSatiety(-1);

        this.diamonds++;
        this.age++;
    }

    //O Comando "$eat" altera em -1 a energia, +4 a saciedade, -2 a limpeza, +0 diamantes,  +1 a idade
    public void eat(){
        if(!this.alive){
            System.out.println("Fail: O pet está morto");
            return;
        }

        this.setEnergy(-1);
        this.setSatiety(4);
        this.setCleaning(-2);

        this.age++;
    }

    //O Comando "$sleep" aumenta energia até o máximo e idade aumenta do número de turnos que o pet dormiu.
    //Os outros atributos permanecem inalterados.
    public void sleep(){
        if(!this.alive){
            System.out.println("Fail: O pet está morto");
            return;
        }

        if(this.getENERGY_MAX() - this.getEnergy() < 5){
            System.out.println("Fail: Pet sem sono");
            return;
        }
        this.age += (this.getENERGY_MAX() - this.getEnergy());
        this.setEnergy(this.getENERGY_MAX());
    }

    //O comando "$clean" alteram em -3 energia, -1 na saciedade, MAX na limpeza, +0 diamantes, +2 na idade.
    public void shower(){
        if(!this.alive){
            System.out.println("Fail: O pet está morto");
            return;
        }

        this.setEnergy(-3);
        this.setSatiety(-1);
        this.setCleaning(this.getCLEANING_MAX());

        this.age += 2;
    }

    //toString Method
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("E:" + this.energy + "/" + this.ENERGY_MAX + ", ");
        sb.append("S:" + this.satiety + "/" + this.SATIETY_MAX + ", ");
        sb.append("L:" + this.cleaning + "/" + this.CLEANING_MAX + ", ");
        sb.append("D:" + this.diamonds + ", " + "I:" + this.age);

        return sb.toString();
    }
}
