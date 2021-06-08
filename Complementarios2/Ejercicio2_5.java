/*Dados 2 ArrayList que contienen horas-trabajadas (array1) y valor-por-hora(array2) del resumen de carga de horas semanal de un empleado.
Se debe generar otra lista que contenga los totales y luego imprimir el total final a cobrar.*/

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2_5 {
    public static void main(String[] args) {
        
        List<Integer> horas = new ArrayList <Integer> ();
        horas.add(1);
        horas.add(2);
        horas.add(3);
        horas.add(4);
        
        List<Integer> valor_hora = new ArrayList <Integer> ();
        valor_hora.add(100);
        valor_hora.add(200);
        valor_hora.add(300);
        valor_hora.add(400);

        List<Integer> semanal = new ArrayList <Integer> ();

        int total = 0;
        for (int i = 0; i < 4; i ++){
            semanal.add(valor_hora.get(i)*horas.get(i));
            total += semanal.get(i);
        }

        System.out.println("Importes semanales $" + semanal);

        System.out.println("Importe mensual $" + total);
    }
}