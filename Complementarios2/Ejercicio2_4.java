/*Cargar un arrayList con 12 nombres de estudiantes (String), luego separarlos en 3 cursos (3 arrayList) e imprimir dichos cursos.*/

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2_4 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> alumnos = new ArrayList <String>();
        String [] nombres = {"Roberto","Manuel","Mabel","Julio","Pedrito","Sonia","Soledad","Micaela","Fede","Ly","Julio","Lucas"};
        
        for(int i=0; i < nombres.length-1; i++){
            alumnos.add(i,nombres[i]);
        }
        
        List<String> curso_1 = alumnos.subList(0, 3);
        List<String> curso_2 = alumnos.subList(4, 7);
        List<String> curso_3 = alumnos.subList(8, 11);

        System.out.println("Alumnos: " + alumnos);
        System.out.println("Curso1: " + curso_1);
        System.out.println("Curso2: " + curso_2);
        System.out.println("Curso3: " + curso_3);
    }
}