public class Espectador {
    private String nombre;
    private byte edad;
    private double dinero;

    public String getNombre() {
        return nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public Espectador() {
    }

    public Espectador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        if(!this.getNombre().equals(null)&&this.getDinero()>0.0&&this.getEdad()>0){
            return "X";
        }else{
            return "_";
        }

    }
}
