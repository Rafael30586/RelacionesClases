
import java.util.Scanner;

public class Cine {
    private Pelicula pelicula;
    private double precioEntrada;
    private Espectador[][] espectadores = new Espectador[8][6];

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public Espectador[][] getEspectadores() {
        return espectadores;
    }

    public void setEspectadores(Espectador[][] espectadores) {
        this.espectadores = espectadores;
    }

    public Cine(Pelicula pelicula) { //al parecer hay que llenar a espectadores con valores por defecto
        this.pelicula = pelicula;
        Espectador espectador;
        byte fila;
        byte columna;
        char continuar='s';
        boolean seSento;
        boolean requisitos;
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Precio de la entrada al cine: ");
        this.setPrecioEntrada(entrada.nextDouble());

        for(int i=0;i<8;i++){
            for(int j=0;j<6;j++){
                espectadores[i][j] = new Espectador(" ");
            }
        }

        while(continuar=='s'){
            requisitos=true;
            seSento = false;
            espectador = new Espectador();
            System.out.println("Nombre del Espectador: ");
            espectador.setNombre(entrada.next());
            System.out.println("Edad: ");
            espectador.setEdad(entrada.nextByte());
            System.out.println("Dinero del que dispone: ");
            espectador.setDinero(entrada.nextDouble());

            while(!seSento&&requisitos){

                fila = (byte)(Math.random()*7); //podria servir un while con seSento == false
                columna = (byte)(Math.random()*5);

                if(espectador.getEdad()>=this.pelicula.getEdadMinima()&&espectador.getDinero()>=this.getPrecioEntrada()){
                    if(espectadores[fila][columna].getNombre().equals(" ")){
                        espectadores[fila][columna] = espectador;
                        seSento=true;
                    }
                    //requisitos=true;
                    /*
                    for(int i=0;i<8;i++){
                        for(int j=0;j<8;j++){
                            if(i==fila && j==columna && (espectadores[i][j].toString().equals(" ")||espectadores[i][j]==null)){
                                espectadores[i][j] = espectador;
                                seSento=true;
                            }

                        }
                    }*/
                }else{
                    System.out.println("Lo lamentamos "+espectador.getNombre()+" no puede ingresar a ver la pelicula");
                    requisitos=false;
                }
            }

            do{
                System.out.println("Desea continuar (s/n)");
                continuar = entrada.next().toLowerCase().charAt(0);
            }while(continuar!='s'&&continuar!='n');

        }
        for(int i=0;i<8;i++){
            for(int j=0;j<6;j++){
                System.out.print(espectadores[i][j].toString()+ " ");
            }
            System.out.println(" ");
        }
    }
}
