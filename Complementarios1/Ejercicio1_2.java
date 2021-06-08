/*Realizar un programa que solicite por consola 2 números enteros. Para luego
imprimir el resultado de la suma, resta, multiplicación, división y módulo (resto
de la división) de ambos números.*/

import java.util.Scanner;

public class Ejercicio1_2 {
    public static void main(String[] args) {
        System.out.println("Ingresar un número: ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Ingresar otro número: ");
        int b = scan.nextInt();
        scan.close();
        System.out.println(a + "+" + b + "=" + (a+b));
        System.out.println(a + "-" + b + "=" + (a-b));
        System.out.println(a + "*" + b + "=" + a*b);
        System.out.println(a + "/" + b + "=" + a/b);
        System.out.println(a + "%" + b + "=" + a%b);
    }
}