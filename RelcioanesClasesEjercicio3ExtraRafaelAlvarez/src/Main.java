import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Poliza> polizas = new ArrayList();
        //System.out.println("Hello world!");

        polizas = registrarPolizas();
        mostrarPolizas(polizas);

        int mes = 10;
        mes++;

        /*
        Date h = new Date((2000-1900),mes,1);
        System.out.println(h);
        System.out.println(h.getMonth());*/
    }

    public static ArrayList<Poliza> registrarPolizas(){
        ArrayList<Poliza> polizas = new ArrayList<>();
        Poliza poliza;
        Date date;
        Cliente cliente;
        Vehiculo vehiculo;
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        char continuar='s';
        char respuesta;
        Cuota[] cuotas;
        int cantidadCuotas;
        double montoCuota;
        String pago;

        while(continuar=='s'){
            date = new Date();
            date.setYear(date.getYear()+1900);
            poliza = new Poliza();
            cliente = new Cliente();
            vehiculo = new Vehiculo();
            System.out.println("Numero de poliza");
            poliza.setNumeroPoliza(entrada.nextInt());
            poliza.setFechaInicio(date);
            System.out.println("Fecha de fin (año, mes y dia)");
            poliza.setFechaFin(new Date(entrada.nextInt(), entrada.nextInt(), entrada.nextInt()));
            System.out.println("Cantidad de cuotas: ");
            cantidadCuotas = entrada.nextInt();
            poliza.setCantidadCuotas(cantidadCuotas);
            cuotas = new Cuota[cantidadCuotas];
            int mes = date.getMonth()+1;

            for(int i=0;i<cuotas.length;i++){
                cuotas[i] = new Cuota();
                cuotas[i].setNumeroCuota(i+1);
            }

            for(int i=0;i<cuotas.length;i++){
                cuotas[i].setVencimiento(new Date(date.getYear(),mes,date.getDate()));
                mes++;
            }

            System.out.println("Forma de pago: ");
            poliza.setFormaDePago(entrada.next());
            System.out.println("Monto total asegurado: ");
            poliza.setMontoTotalAsegurado(entrada.nextDouble());

            do{
                System.out.println("Incluye granizo?(s/n): ");
                respuesta = entrada.next().toLowerCase().charAt(0);
                if(respuesta=='s'){
                    poliza.setIncluyeGranizo(true);
                }else if(respuesta=='n'){
                    poliza.setIncluyeGranizo(false);
                }
            }while(respuesta!='s'&&respuesta!='n');

            if(poliza.isIncluyeGranizo()){
                System.out.println("Monto maximo para granizo: ");
                poliza.setMontoMaximoGranizo(entrada.nextDouble());
            }

            System.out.println("Tipo de cobertura: ");
            poliza.setTipoCobertura(entrada.next());

            System.out.println("Nombre del cliente");
            cliente.setNombre(entrada.next());
            System.out.println("Apellido: ");
            cliente.setApellido(entrada.next());
            System.out.println("DNI: ");
            cliente.setDni(entrada.nextLong());
            System.out.println("Email: ");
            cliente.setEmail(entrada.next());
            System.out.println("Domicilio: ");
            cliente.setDomicilio(entrada.next());
            System.out.println("Telefono: ");
            cliente.setTelefono(entrada.next());

            poliza.setCliente(cliente);

            System.out.println("Marca del vehiculo: ");
            vehiculo.setMarca(entrada.next());
            System.out.println("Modelo: ");
            vehiculo.setModelo(entrada.next());
            System.out.println("Año: ");
            vehiculo.setAnio(entrada.nextInt());
            System.out.println("Numero de motor: ");
            vehiculo.setNumeroMotor(entrada.next());
            System.out.println("Chasis: ");
            vehiculo.setChasis(entrada.next());
            System.out.println("Color: ");
            vehiculo.setColor(entrada.next());
            System.out.println("Tipo: ");
            vehiculo.setTipo(entrada.next());

            poliza.setVehiculo(vehiculo);

            System.out.println("Monto total de cada cuota: ");
            montoCuota = entrada.nextDouble();

            for(int i=0;i<cuotas.length;i++){
                cuotas[i].setMontoTotalCuota(montoCuota);
            }
/*
            System.out.println("Forma de pago: ");
            pago = entrada.next();*/

            for(int i=0;i<cuotas.length;i++){
                cuotas[i].setFormaDePago(poliza.getFormaDePago());
            }

            System.out.println("Cuantas cuotas ha pagado?: ");
            cantidadCuotas = entrada.nextInt();

            for(int i=0;i<cantidadCuotas;i++){
                cuotas[i].setPagada(true);
            }

            poliza.setCuotas(cuotas);

            polizas.add(poliza);

            System.out.println("Desea crear otra poliza?(s/n): ");
            continuar = entrada.next().toLowerCase().charAt(0);

        }
        return polizas;
    }

    public static void mostrarPolizas(ArrayList<Poliza> polizas){ //ojo con imprimir las fechas, los meses estan como array
        int mesFin;
        int mesInicio;

        for(Poliza poliza : polizas){
            mesFin = poliza.getFechaFin().getMonth()+1;
            mesInicio = poliza.getFechaInicio().getMonth()+1;
            System.out.println("Numero de poliza: " + poliza.getNumeroPoliza());
            System.out.println("Cliente: " + poliza.getCliente());
            System.out.println("Datos del Vehiculo: " + poliza.getVehiculo());
            System.out.println("Fecha de inicio: " + poliza.getFechaInicio().getDate()+"/"+mesInicio+"/"+poliza.getFechaInicio().getYear());
            System.out.println("Fecha de fin: " + poliza.getFechaFin().getDate()+"/"+mesFin+"/"+poliza.getFechaFin().getYear());
            if(poliza.isIncluyeGranizo()){
                System.out.println("Incluye granizo");
                System.out.println("Monto maximo para granizo: $"+poliza.getMontoMaximoGranizo());
            }
            System.out.println("Tipo de cobertura: "+poliza.getTipoCobertura());
            mostrarCuotas(poliza.getCuotas());
        }
    }

    public static void mostrarCuotas(Cuota[] cuotas){
        for(int i=0;i<cuotas.length;i++){
            System.out.print(cuotas[i]);
            if(cuotas[i].isPagada()){
                System.out.println(" Pagada");
            }else{
                System.out.println(" ");
            }
        }
        System.out.println("------------------------------------------------------------");
    }
}