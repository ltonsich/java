/*Confeccionar un programa que dado un número entero como dato de entrada imprima la secuencia de números (incrementos de 1)*/

import java.util.Scanner;

public class Ejercicio1_3 {
    public static void main(String[] args) {
        System.out.println("Ingresar un número distinto de cero:");
        Scanner scan = new Scanner(System.in);
        int nro = scan.nextInt();
        scan.close();
        for(int i = 0; i <= nro ; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}