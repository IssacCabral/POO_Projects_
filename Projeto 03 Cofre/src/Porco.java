class Porco{
    String coisas = "";
    double valor = 0;
    int volume = 0;
    int volumeMax;
    boolean estaQuebrado = false;

    public Porco(int volumeMax){
        this.volumeMax = volumeMax;
    }
    public boolean adicionarDinheiro(Moeda moeda){
        if(estaQuebrado){
            System.out.println("O porco está quebrado");
            return false;
        }
        if(moeda.getVolume() + this.volume > volumeMax){
            System.out.println("A moeda não cabe no porco");
            return false;
        }

        this.valor += moeda.getValor();
        this.volume += moeda.getVolume();

        return true;
    }
    public boolean adicionarItem(Item item){
        if(estaQuebrado){
            System.out.println("O porco está quebrado");
            return false;
        }
        if(this.volume + item.volume > volumeMax){
            System.out.println("Adicionar um(a) " + item.descricao + " não cabe no porco");
            return false;
        }
        this.volume += item.volume;
        if(this.coisas.equals(""))
            this.coisas += item.descricao;
        else
            this.coisas += ", " + item.descricao;
        return true;
    }

    public boolean quebrar(){
        if(estaQuebrado){
            return false;
        }
        estaQuebrado = true;
        return true;
    }

    public double pegarDinheiro(){
        if(!estaQuebrado){
            System.out.println("Quebre para pegar o dinheiro");
            return 0;
        }
        double aux = this.valor;
        this.valor = 0;
        return aux;
    }

    public String pegarCoisas(){
        if(!estaQuebrado){
            System.out.println("Quebre para pegar o dinheiro");
            return "";
        }
        String aux = this.coisas;
        this.coisas = "";
        return aux;
    }

    @Override
    public String toString() {
        return "Porco{" +
                "coisas='" + coisas + '\'' +
                ", valor=" + valor +
                ", volume=" + volume +
                ", volumeMax=" + volumeMax +
                ", estaQuebrado=" + estaQuebrado +
                '}';
    }
}
