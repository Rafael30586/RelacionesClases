import java.util.*;

public class Baraja {
    private List<Carta> cartas = new ArrayList<>();
    private HashSet<Carta> queHanSalido = new HashSet<>();

    public Baraja() {
        for(int i=0;i<12;i++){
            if(i==7 || i==8){
                continue;
            }
            cartas.add(new Carta(i+1,Palo.BASTO));
        }

        for(int i=0;i<12;i++){
            if(i==7 || i==8){
                continue;
            }
            cartas.add(new Carta(i+1,Palo.ORO));
        }

        for(int i=0;i<12;i++){
            if(i==7 || i==8){
                continue;
            }
            cartas.add(new Carta(i+1,Palo.ESPADA));
        }

        for(int i=0;i<12;i++){
            if(i==7 || i==8){
                continue;
            }
            cartas.add(new Carta(i+1,Palo.COPA));
        }
    }


    public void barajar(){
        Collections.shuffle(cartas);
    }

    public Carta siguienteCarta(){

        ArrayList<Carta> listaCartas = new ArrayList<>(cartas);
        if(!cartas.isEmpty()){
            System.out.println(cartas.get(0));
            queHanSalido.add(cartas.get(0));
            cartas.remove(0);
            return listaCartas.get(0);
        }else{
            System.out.println("No hay suficientes cartas");
        }
        return new Carta();
    }

    public void cartasDisponibles(){
        System.out.println("Cartas: "+cartas.size());
    }

    public ArrayList<Carta> darCartas(){
        int c;
        int posicion;
        ArrayList<Carta> puniadoCartas = new ArrayList<>();

        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Cantidad de cartas: ");
        c = entrada.nextInt();

        if(c<=cartas.size()){
            for(int i=0;i<c;i++){
                posicion = (int)(Math.random()*40);
                if(posicion>=cartas.size()){
                    i-=1;
                    continue;
                }
                puniadoCartas.add(cartas.get(posicion));
                queHanSalido.add(cartas.get(posicion));
                cartas.remove(posicion);
            }
        }else{
            System.out.println("No habian suficientes cartas...");
        }
        System.out.println("Cartas dadas: "+ puniadoCartas);

        return puniadoCartas;
    }

    public void cartasMonton(){
        System.out.println("Cartas que ya han salido: "+ queHanSalido);
    }

    public void mostrarBaraja(){
        System.out.println("Cartas restantes: "+ cartas);
    }
}
