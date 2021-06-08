/*Se desea una aplicación que solicite 2 números enteros y realice la operación de multiplicación por sumas sucesivas*/

import java.util.Scanner;

public class Ejercicio1_5 {
    public static void main(String[] args) {
        System.out.println("Ingresar un número:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Ingresar otro número:");
        int b = scan.nextInt();
        scan.close();
        int producto = 0;
        for(int i = 1; i <= a ; i++){
            producto = producto + b;
        }
        System.out.println(a + " X " + b + " = " + producto);
    }
}