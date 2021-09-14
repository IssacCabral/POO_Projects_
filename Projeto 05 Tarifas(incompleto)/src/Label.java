public enum Label {
    ABERTURA("abertura"),
    DEPOSITO("deposito"),
    EXTORNO("extorno"),
    SAQUE("saque"),
    TARIFA("tarifa");

    private String name;
    Label(String name){
        this.name = name;
    }

    public String getName(){return this.name;}
    public String toString(){return this.name;}
}
