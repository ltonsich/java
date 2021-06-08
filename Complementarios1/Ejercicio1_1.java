/*Solicitar por consola el nombre del usuario e imprimir por pantalla el siguiente
mensaje “HOLA {USUARIO}!!!”*/

import java.util.Scanner;

public class Ejercicio1_1 {
    public static void main(String[] args) {
        System.out.println("Ingresar nombre de usuario: ");
        Scanner scan = new Scanner(System.in);
        String usuario = scan.next();
        scan.close();
        System.out.println("Hola " + usuario);
    }
}