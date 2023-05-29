import java.util.*;

public class Simulador {

    HashSet<Voto> votos = new HashSet<>();

    public ArrayList<Alumno> generarNombres(int cantidadAlumnos){
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<String> apellidos = new ArrayList<>();
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        byte numeroNombre;
        byte numeroApellido;
        Alumno alumno;

        nombres.add("Federico");
        nombres.add("Mariela");
        nombres.add("David");
        nombres.add("Micaela");
        nombres.add("Gonzalo");
        nombres.add("Paola");
        nombres.add("Miguel");
        nombres.add("Florencia");
        nombres.add("Maximiliano");
        nombres.add("Isabel");
        nombres.add("Rafael");
        nombres.add("Susana");
        nombres.add("Juan");
        nombres.add("Alejandra");
        nombres.add("Diego");
        nombres.add("Belen");
        nombres.add("Carlos");
        nombres.add("Agustina"); //18

        Collections.shuffle(nombres);

        apellidos.add("Maradona");
        apellidos.add("Gates");
        apellidos.add("Musk");
        apellidos.add("Gimenez");
        apellidos.add("Iwata");
        apellidos.add("Spencer");
        apellidos.add("Jackson");
        apellidos.add("Noriega");
        apellidos.add("Cervantes");
        apellidos.add("Carrey");
        apellidos.add("Smith");
        apellidos.add("Perez");
        apellidos.add("Lopez");
        apellidos.add("Messi");
        apellidos.add("Ortega");
        apellidos.add("Carmack");
        apellidos.add("Einstein");
        apellidos.add("Newton");
        apellidos.add("Gauss");
        apellidos.add("Miyamoto");
        apellidos.add("Greenberg");
        apellidos.add("Mendez"); //22

        Collections.shuffle(apellidos);

        for(int i=0;i<cantidadAlumnos;i++){
            numeroNombre = (byte)(Math.random()*17);
            numeroApellido = (byte)(Math.random()*21);
            alumno = new Alumno();
            alumno.setNombreCompleto(nombres.get(numeroNombre)+" "+apellidos.get(numeroApellido));
            listaAlumnos.add(alumno);
        }

        return listaAlumnos;
    }

    public ArrayList<Long> generarDNIs(int cantidadAlumnos){ //desde 25_000_000 hasta 45_000_000
        ArrayList<Long> listaDNIs = new ArrayList<>(); //podria ser un array en lugar de una coleccion?
        Long dni; // o un hashset para que no hayan duplicados

        for(int i=0;i<cantidadAlumnos;i++){
            dni = (long)(Math.random()*45_000_000);
            if(dni>25_000_000 && dni<50_000_000){
                listaDNIs.add(dni);
            }else{
                i--;
            }
        }
        return listaDNIs;
    }

    public ArrayList<Alumno> generarAlumnos(){
        ArrayList<Alumno> listaAlumnos;
        ArrayList<Long> listaDNIs;
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        int cantidadAlumnos;

        System.out.println("Cuantos alumnos desea crear?");
        cantidadAlumnos = entrada.nextInt();

        listaAlumnos = generarNombres(cantidadAlumnos);
        listaDNIs = generarDNIs(cantidadAlumnos);

        for(int i=0;i<cantidadAlumnos;i++){
            listaAlumnos.get(i).setDni(listaDNIs.get(i));
        }

        return listaAlumnos;
    }

    public void mostrarAlumnos(ArrayList<Alumno> alumnos){
        //ArrayList<Alumno> listaAlumnos = generarAlumnos();
        for(Alumno alumno : alumnos){
            System.out.println(alumno.getNombreCompleto());
            System.out.println(alumno.getDni());
        }
    }

    public void votacion(ArrayList<Alumno> alumnos){ //tres votos para cada alumno de forma aleatoria
        Voto voto;
        Alumno[] votados;
        ArrayList<Alumno> listaCopia = new ArrayList<>(alumnos);


        for(Alumno a : alumnos){ //arreglar para que no se voten a si mismos
            voto = new Voto();
            voto.setAlumno(a);
            votados = new Alumno[3];
            for(int i=0;i<3;i++){
                votados[i] = new Alumno();
            }
            Collections.shuffle(listaCopia);

            for(int i=0;i<3;i++){
                votados[i] = listaCopia.get(i);
            }
            /*
            int k=0;
            while(votados[k].getDni()==0 && k<2){
                votados[k] = listaCopia.get(k);
                if(a.equals(listaCopia.get(k))){

                    votados[k] = new Alumno();
                    continue;
                }
                k++;
            }*/
            voto.setVotados(votados);
            votos.add(voto);
        }


        for(Voto v : votos){
            votados = new Alumno[3];
            votados = v.getVotados();
            for(int i=0;i<alumnos.size();i++){
                for(int j=0;j<votados.length;j++){
                    if(alumnos.get(i).getDni()==votados[j].getDni()){
                        alumnos.get(i).setVotosRecibidos(alumnos.get(i).getVotosRecibidos()+1);
                    }
                }

            }
        }

    }

    public void mostrarVotacion(ArrayList<Alumno> alumnos){ //si transformo en array al atributo votados habria que cambiar este metodo
        /*
        for(Voto v : votos){ //y el toString de la clase voto
            System.out.println(v);
        }*/
        ArrayList<Voto> votosLista = new ArrayList<>(votos);
        for(int i=0;i<votos.size();i++){
            System.out.println(votosLista.get(i));
        }

        for(int i=0;i<alumnos.size();i++){
            System.out.println(alumnos.get(i).getNombreCompleto()+": "+alumnos.get(i).getVotosRecibidos()+" votos recibidos");
        }
    }

    public void elegirFacilitadores(ArrayList<Alumno> alumnos){ //comparator para ordenar a alumnos segun...
        Alumno[] facilitadores = new Alumno[10]; //...votos recibidos
        //Alumno[] facilitadoresSuplentes = new Alumno[5];
        ArrayList<Alumno> copiaLista = new ArrayList<>(alumnos);
        //Collections.sort(copiaLista,Alumno.compararVotos);
        copiaLista.sort(Alumno.compararVotos);
        Collections.reverse(copiaLista);
        for(int i=0;i<facilitadores.length;i++){
            facilitadores[i] = copiaLista.get(i);
            copiaLista.remove(i);
            if(copiaLista.isEmpty()){
                break;
            }
        }

        System.out.println("Facilitadores titulares: ");
        for(int i=0;i<facilitadores.length;i++){
            System.out.println(facilitadores[i] + " ("+facilitadores[i].getNombreCompleto()+") ");
            if(i==4){
                System.out.println("Facilitadores suplentes: ");
            }
        }


    }
}
