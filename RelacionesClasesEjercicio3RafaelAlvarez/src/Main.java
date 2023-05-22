import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
        //System.out.println("Hello world!");
    }

    public static void menu(){
        Baraja b = new Baraja();
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        byte opcion;

        do{
            System.out.println("Elija una opcion");
            System.out.println("1- Barajar");
            System.out.println("2- Siguiente carta");
            System.out.println("3- Cartas disponibles");
            System.out.println("4- Dar cartas");
            System.out.println("5- Cartas que ya han salido");
            System.out.println("6- Cartas restantes");
            System.out.println("7- Salir");
            opcion = entrada.nextByte();

            switch (opcion){
                case 1: b.barajar();break;
                case 2: b.siguienteCarta();break;
                case 3: b.cartasDisponibles();break;
                case 4: b.darCartas();break;
                case 5: b.cartasMonton();break;
                case 6: b.mostrarBaraja();break;
                case 7: System.out.println("Saliendo del programa...");break;
                default: System.out.println("opcion no disponible");break;
            }
        }while(opcion!=7);
    }
}