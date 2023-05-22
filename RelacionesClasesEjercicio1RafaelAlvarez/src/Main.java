import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Perro pr1 = new Perro("Firulais","Collie",10,"Grande");
        Perro pr2 = new Perro("Sultan","Doberman",6,"Grande");
        Persona ps1 = new Persona("Osvaldo","Martinez",28,35_291_002,null); //cambiado a null para ejercicio 1 extra
        Persona ps2 = new Persona("Mariana","Soza",21,40_291_002,null);
        /*ps1.mostrarPersonaYMascota();
        ps2.mostrarPersonaYMascota();*/

        //A partir de aca ejercicio 1 extra

        Perro pr3 = new Perro("Yoshi","Salchicha",4,"Chico");
        Perro pr4 = new Perro("Kripto","Ovejero",7,"Grande");
        Perro pr5 = new Perro("Angelo","Siberian Husky",11,"Mediano");
        Perro pr6 = new Perro("Snoopy","Pequines",14,"Chico");

        Persona ps3 = new Persona("Cristian","Miranda",20,41_243_100,null);
        Persona ps4 = new Persona("Eduardo","Molinari",38,31_772_909,null);
        Persona ps5 = new Persona("Ludmila","Weiss",30,38_729_910,null);
        Persona ps6 = new Persona("Lola","Nicohls",24,48_711_010,null);

        ArrayList<Perro> mascotas = new ArrayList<>(6);
        ArrayList<Persona> personas = new ArrayList<>(6);

        mascotas.add(pr1);
        mascotas.add(pr2);
        mascotas.add(pr3);
        mascotas.add(pr4);
        mascotas.add(pr5);
        mascotas.add(pr6);

        personas.add(ps1);
        personas.add(ps2);
        personas.add(ps3);
        personas.add(ps4);
        personas.add(ps5);
        personas.add(ps6);

        asignarMascotas(personas,mascotas);

        //System.out.println("Hello world!");
    }

    public static void asignarMascotas(ArrayList<Persona> personas, ArrayList<Perro> mascotas){
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        String nombre;
        boolean encontro;

        for(int i=0;i<personas.size();i++){
            encontro=false;
            do{System.out.println("Mascota para "+personas.get(i).getNombre()+" "+personas.get(i).getApellido()+"?");
                System.out.println("Lista de mascotas: "+mascotas);
                nombre = entrada.next().toUpperCase();
                for(int j=0;j<mascotas.size();j++){
                    if(nombre.equals(mascotas.get(j).getNombre().toUpperCase())){
                        personas.get(i).setPerro(mascotas.get(j));
                        mascotas.remove(mascotas.get(j));
                        encontro = true;
                    }
                }
                if(!encontro){
                    System.out.println("Mascota no encontrada");
                }
            }while(!encontro);

        }
        System.out.println(personas);
    }
}