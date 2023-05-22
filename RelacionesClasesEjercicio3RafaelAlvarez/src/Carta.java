public class Carta {
    private Integer numero;
    private Palo palo;

    @Override
    public String toString(){
        String palo = this.getPalo().toString();
        String numero = this.getNumero().toString();
        //String carta = numero + " de " + palo;
        return numero + " de " + palo;
    }

    public Integer getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public Carta(Integer numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Carta() {
    }
}

enum Palo{
    BASTO(1), ESPADA(2), COPA(3), ORO(4);
    Palo(int palo){}
}

