/*Realizar un programa que calcule el factorial de un número: n! = 1 x 2 x … x (n-1) x n.
Sin hacer uso de librerías.*/

import java.util.Scanner;

public class Ejercicio1_4 {
    public static void main(String[] args) {
        System.out.println("Ingresar un número distinto de cero:");
        Scanner scan = new Scanner(System.in);
        int nro = scan.nextInt();
        scan.close();
        int factor = 1;
        for(int i = 2; i <= nro ; i++){
            factor = factor * i;
        }
        System.out.println("El factorial de " + nro + " es " + factor);
    }
}