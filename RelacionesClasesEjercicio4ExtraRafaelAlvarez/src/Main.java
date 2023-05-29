import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        //simulador.mostrarAlumnos();

        ArrayList<Alumno> alumnos = simulador.generarAlumnos();
        simulador.mostrarAlumnos(alumnos);
        simulador.votacion(alumnos);
        simulador.mostrarVotacion(alumnos);
        simulador.elegirFacilitadores(alumnos);

        //System.out.println("Hello world!");
    }
}