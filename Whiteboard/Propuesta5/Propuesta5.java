package Whiteboard.Propuesta5;

/*Ejercicio Propuesto #5: Dado un archivo de texto (.txt) con el formato:
{nombre},{apellido},{fecha de nacimiento},{sueldo}*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Propuesta5{
    public static void main(String[] args){
        System.out.println("Ejercicio 5 - Propuesto");
        List<Empleado> listaEmpleados = new ArrayList<Empleado>();
        listaEmpleados = leerListaEmpleados(listaEmpleados, "Ejercicios_Repaso/Ejercicio_5/empleados.txt");

        imprimirMenu(5,listaEmpleados);
    }

public static void imprimirMenu(int opciones,List<Empleado> listaEmpleados){
    Scanner sc = new Scanner(System.in);
    int op=0;
    do{
        System.out.println("\n\n\t\t********************** Menu *****************\n\n\t\t");
        System.out.println("1-Buscar empleado que comience con una letra dada en el apellido\n");
        System.out.println("2-Mostrar el empleado de menor edad y el de mayor edad\n");
        System.out.println("3-Mostrar el empleado de menor salario y el de mayor salario.\n");
        System.out.println("4-Imprimir todos los empleados en orden alfabético (por nombre y por apellido)\n");
        System.out.println("5-Salir\n");

        try{
        op = sc.nextInt();
        sc.nextLine();
        }
        catch (Exception e){
            sc.nextLine();
            continue;
        }
        switch (op){
            case 1:
            System.out.println("Ingresar letra : ");
            String letra = sc.nextLine();

            List<Empleado>listaEmpleadosApellidos =  getEmpleadosLetraApellido(letra.charAt(0),listaEmpleados);

            if (listaEmpleadosApellidos.size()==0){
                System.out.println("No hay empleados cuyo apellido  empiece con "+letra);
            }
            else{
                imprimirLista(listaEmpleadosApellidos);
            }
            break;

            case 2:
            Map<String, ArrayList<Empleado>> listaMayorMenor = getMayoryMenorEdad(listaEmpleados);

            if ( listaMayorMenor.size()==0){
                System.out.println("No hay empleados en la lista");
            }

            else{
                for (Map.Entry<String, ArrayList<Empleado>> map : listaMayorMenor.entrySet()){
                    System.out.println("\n\n -- "+map.getKey()+" -- \n\n ");

                    for (Empleado empleado : map.getValue()){
                        System.out.println(" { Nombre: "+ empleado.getNombre() + " , Apellido : "+ empleado.getApellido() + " , Edad : "+ empleado.calcularEdad() + " }");
                    }
                }
            }
            break;

            case 3:
            Map<String, ArrayList<Empleado>> listaMayorMenorSueldo = getMayoryMenorSueldo(listaEmpleados);

            if ( listaMayorMenorSueldo.size()==0){
                System.out.println("No hay empleados en la lista");
            }

            else{
                for (Map.Entry<String, ArrayList<Empleado>> map : listaMayorMenorSueldo.entrySet()){
                    System.out.println("\n\n -- "+map.getKey()+" -- \n\n ");
        
                    for (Empleado empleado : map.getValue()){
                        System.out.println(" { Nombre: "+ empleado.getNombre() + " , Apellido : "+ empleado.getApellido() + " , Sueldo : "+ empleado.getSueldo() + " }");
                    }
                }
            }
            break;

            case 4:
            List<Empleado>listaEmpleadosOrdenAlf =  listOrdenAlfabetico(listaEmpleados);

            if (listaEmpleadosOrdenAlf.size()==0){
                System.out.println("No hay empleados en la lista");
            }
            else{
                imprimirLista(listaEmpleadosOrdenAlf);
            }
            break;
        
            default:
                break;
        }
    }
    while (op!=5);
    sc.close();
}


public static void imprimirLista(List<Empleado>listaEmpleados){
    for (Empleado empleado : listaEmpleados){
        System.out.println(empleado.toString());
    }
}


public static List<Empleado> leerListaEmpleados(List<Empleado> listaEmpleados, String path){
    String currentLine;
    BufferedReader reader = null;
    
    try{
        reader = new BufferedReader(new FileReader(path));
        while ((currentLine = reader.readLine()) != null){
            listaEmpleados.add(separarAtributos(currentLine));
        }
    }
    catch (IOException e){
        e.printStackTrace();
    }
    finally{
        try{
            if (reader != null){
                reader.close();
            }
        }
        catch (IOException e2){
            e2.printStackTrace();
        }
    }
    return listaEmpleados;
}

public static Empleado separarAtributos(String currentLine){
    String [] datosEmpleado = currentLine.split(",");
    Double sueldo = parsearSueldo(datosEmpleado[3]);
    LocalDate fechaNacimiento = formatearFecha(datosEmpleado[2], "dd-MM-yyyy");
    Empleado e = new Empleado(datosEmpleado[0], datosEmpleado[1],fechaNacimiento,sueldo);
    return e;
}

public static LocalDate formatearFecha(String fecha, String formato){
    DateTimeFormatter format = DateTimeFormatter.ofPattern(formato);
    return LocalDate.parse(fecha,format);
}

public static Double parsearSueldo(String sueldo) {
    return Double.parseDouble(sueldo);
}

public static List<Empleado> getEmpleadosLetraApellido(char letra, List<Empleado>listaEmpleados){
    List<Empleado> listaFiltrada = new ArrayList<Empleado>();
    for (Empleado e : listaEmpleados){
        if (Character.toLowerCase(e.getApellido().charAt(0))== Character.toLowerCase(letra)){
            listaFiltrada.add(e);
        }
    }
    return listaFiltrada;
} 

public static Map<String,ArrayList<Empleado>> getMayoryMenorEdad (List<Empleado>listaEmpleados){
    Map<String,ArrayList<Empleado>>mayorMenor= new HashMap<String, ArrayList<Empleado>>();
    ArrayList<Empleado> mayores = new ArrayList<Empleado>();
    ArrayList<Empleado> menores = new ArrayList<Empleado>();
    int auxMayor=listaEmpleados.get(0).calcularEdad(), auxMenor=listaEmpleados.get(0).calcularEdad();
    for (Empleado e : listaEmpleados){
        int edad=e.calcularEdad();
        if (edad<auxMenor){
            auxMenor=edad;
            menores.removeAll(menores);
            menores.add(e);
        }
        else if(edad==auxMenor){
            menores.add(e);
        }
        if (edad>auxMayor){
            auxMayor=edad;
            mayores.removeAll(mayores);
            mayores.add(e);
        }
        else if(edad==auxMayor){
            mayores.add(e);
        }
    }
    mayorMenor.put("Mayor/es", mayores);
    mayorMenor.put("Menor/es", menores);
    return mayorMenor;
}

public static Map<String,ArrayList<Empleado>> getMayoryMenorSueldo(List<Empleado>listaEmpleados){
    Map<String,ArrayList<Empleado>>mayorMenor= new HashMap<String, ArrayList<Empleado>>();
    ArrayList<Empleado> mayores = new ArrayList<Empleado>();
    ArrayList<Empleado> menores = new ArrayList<Empleado>();
    double auxMayorSueldo=listaEmpleados.get(0).getSueldo(), auxMenorSueldo=listaEmpleados.get(0).getSueldo();
    for (Empleado e : listaEmpleados){
        double sueldo = e.getSueldo();
        if (sueldo>auxMayorSueldo){
            auxMayorSueldo=sueldo;
            mayores.removeAll(mayores);
            mayores.add(e);
        }
        else if(sueldo==auxMayorSueldo){
            mayores.add(e);
        }
        if (sueldo<auxMenorSueldo){
            auxMenorSueldo=sueldo;
            menores.removeAll(menores);
            menores.add(e);
        }
        else if(sueldo==auxMenorSueldo){
            menores.add(e);
        }
    }
    mayorMenor.put("Mayor/es sueldos", mayores);
    mayorMenor.put("Menor/es sueldos", menores);
    return mayorMenor;
}

public static List<Empleado> listOrdenAlfabetico(List<Empleado> listaEmpleados){
    List<Empleado> listadoOrdenAlf = listaEmpleados.stream().sorted(Comparator.comparing(n->n.toString())).collect(Collectors.toList());
    return listadoOrdenAlf;
}

}