class Item{
    String descricao;
    int volume;

    public Item(String descricao, int volume){
        this.descricao = descricao;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Item{" +
                "descricao='" + descricao + '\'' +
                ", volume=" + volume +
                '}';
    }
}
