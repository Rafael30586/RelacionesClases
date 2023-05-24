public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private String numeroMotor;
    private String chasis;
    private String color;
    private String tipo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{" +
                "Marca='" + marca + '\'' +
                ", Modelo='" + modelo + '\'' +
                ", Año=" + anio +
                ", Numero de motor='" + numeroMotor + '\'' +
                ", Chasis='" + chasis + '\'' +
                ", Color='" + color + '\'' +
                ", Tipo='" + tipo + '\'' +
                '}';
    }
}
