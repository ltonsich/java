/*Crear una aplicación que solicite de entrada los datos de una persona en este orden:
Nombre y Apellido, Edad, Dirección, Ciudad, Luego imprimirá el siguiente mensaje:
{Ciudad} - {Dirección} - {Edad} - {Nombre y Apellido}*/

import java.util.Scanner;

public class Ejercicio1_8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar Nombre  : ");
        String nombre = scan.nextLine();
        System.out.println("Ingresar Apellido  : ");
        String apellido = scan.nextLine();
        System.out.println("Ingresar Edad : ");
        int edad = scan.nextInt();
        scan.nextLine();
        System.out.println("Ingresar Dirección : ");
        String direccion = scan.nextLine();
        System.out.println("Ingresar Ciudad : ");
        String ciudad = scan.nextLine();

        Persona p = new Persona(nombre,apellido,edad,direccion,ciudad);

        System.out.println(p.toString());
        
        scan.close();
    }
}