/*Se desea una aplicación que solicite 2 números enteros y realice la operación de potencia*/

import java.util.Scanner;

public class Ejercicio1_6 {
    public static void main(String[] args) {
        System.out.println("Ingresar la base:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Ingresar el exponente:");
        int b = scan.nextInt();
        scan.close();
        int potencia = 1;
        for(int i = 1; i <= b ; i++){
            potencia = potencia * a;
        }
        System.out.println(a + " elevado a " + b + " = " + potencia);
    }
}