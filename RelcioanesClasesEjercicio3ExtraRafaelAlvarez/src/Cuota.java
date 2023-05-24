import java.util.Date;

public class Cuota {
    private int numeroCuota;
    private double montoTotalCuota;
    private boolean pagada;
    private Date vencimiento;
    private String formaDePago;

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getMontoTotalCuota() {
        return montoTotalCuota;
    }

    public void setMontoTotalCuota(double montoTotalCuota) {
        this.montoTotalCuota = montoTotalCuota;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    @Override
    public String toString(){
        int mes = vencimiento.getMonth()+1;
        return "Cuota "+numeroCuota+": $"+montoTotalCuota+" Vencimiento: "+vencimiento.getDate()+"/"+mes+"/"+vencimiento.getYear();
    }
}
