import java.util.Comparator;

public class Alumno {
    private String nombreCompleto;
    private long dni;
    //private int cantidadVotos = 0; //votos otorgados
    private int votosRecibidos = 0; //votos recibidos

    public Alumno() {
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getVotosRecibidos() {
        return votosRecibidos;
    }

    public void setVotosRecibidos(int votosRecibidos) {
        this.votosRecibidos = votosRecibidos;
    }

    @Override
    public String toString(){
        return "DNI de alumno: " + this.getDni();
    }

    public static Comparator<Alumno> compararVotos = new Comparator<Alumno>(){
        @Override
        public int compare(Alumno a1,Alumno a2){
            return Integer.valueOf(a1.getVotosRecibidos()).compareTo(Integer.valueOf(a2.getVotosRecibidos()));
        }
    };

}
