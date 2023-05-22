import java.util.Scanner;

public class Pelicula {
    private String titulo;
    private double duracion;
    private byte edadMinima;
    private String director;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public byte getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(byte edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Pelicula() {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Nombre de la pelicula: ");
        this.setTitulo(entrada.next());
        System.out.println("Duracion: ");
        this.setDuracion(entrada.nextDouble());
        System.out.println("Edad minima: ");
        this.setEdadMinima(entrada.nextByte());
        System.out.println("Director: ");
        this.setDirector(entrada.next());
    }

    public Pelicula(String titulo, double duracion, byte edadMinima, String director) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.director = director;
    }
}
