public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private long documento;
    private Perro perro;

    public Persona(String nombre, String apellido, int edad, long documento, Perro perro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perro = perro;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public long getDocumento() {
        return documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public void mostrarPersonaYMascota(){
        System.out.println("--------------------------------------------------");
        System.out.println("Nombre: "+ this.getNombre());
        System.out.println("Apellido: "+ this.getApellido());
        System.out.println("Edad: "+ this.getEdad());
        System.out.println("Documento: "+ this.getDocumento());
        System.out.println("Nombre de mascota: "+ this.getPerro().getNombre()+" ;Raza: "+ this.getPerro().getRaza()+ " ;Edad: "+this.getPerro().getEdad()+ " ;Tamaño: "+this.getPerro().getTamanio());
        System.out.println("--------------------------------------------------");
    }

    public String toString(){
        return this.getNombre() + " "+ this.getApellido() + " dueño/a de " + this.getPerro();
    }
}
