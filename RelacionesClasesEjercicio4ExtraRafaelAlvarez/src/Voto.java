import java.util.ArrayList;
import java.util.HashSet;

public class Voto {
    private Alumno alumno; //alumno que vota
    //private HashSet<Alumno> votados = HashSet.newHashSet(3); alumnos a los que voto, podria ser una array
    private Alumno[] votados = new Alumno[3]; //alumnos a los que voto

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno[] getVotados() {
        return votados;
    }

    public void setVotados(Alumno[] votados) {
        this.votados = votados;
    }

    @Override
    public String toString() {
        return " " +
                "alumno: " + alumno.getNombreCompleto() + " ("+alumno.getDni()+") "+
                ", voto a: " + votados[0].getDni() + ", "+ votados[1].getDni() + ", " + votados[2].getDni() +
                ' ';
    }
}
