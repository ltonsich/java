/*Se dispone de una lista de Empleados, de cada empleado se conoce: Nombre y Apellido, DNI, horasTrabajadas, valorPorHora
Todos los empleados están cargados en un Set (HashSet), se desea calcular el sueldo (horasTrabajadas x valorPorHora) de toda esa lista para luego almacenar en un Map (o Diccionario) donde la clave (key) es el dni y el valor (value) es el sueldo calculado.*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<Empleado> listaEmpleados = new HashSet<Empleado>();
        Map<String, String> empleadosData = new HashMap<String, String>();

        Empleado e1 = new Empleado("Juan Perez", "45321123", 45, 500.50);
        Empleado e2 = new Empleado("Adrian Gonzalez","54678876",43,300);
        Empleado e3 = new Empleado("Laura Gomez","36363363",40,400);
        Empleado e4 = new Empleado("Carolina Lopez","37377777",45,630);

        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        listaEmpleados.add(e4);

        empleadosData.put(e1.getDni(), " $"+e1.getTotalPagar());
        empleadosData.put(e2.getDni(), " $"+e2.getTotalPagar());
        empleadosData.put(e3.getDni(), " $"+e3.getTotalPagar());
        empleadosData.put(e4.getDni(), " $"+e4.getTotalPagar());
        System.out.println("\n\n***************************************************\n\n");

        System.out.println("Listado de empleados :  ");

        for (Empleado empleado : listaEmpleados) {
            empleado.info();
        }

        System.out.println("\n\n***************************************************\n\n");
        System.out.println("Empleado (DNI)- Sueldo : "+ empleadosData);
        System.out.println("\n\n***************************************************\n\n");

        sc.close();
    }
}
