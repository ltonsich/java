/*Crear un ArrayList, agregar 5 números enteros. Luego, agregar un número
entero al principio de la lista y otro al final. Por último, iterar e imprimir los
elementos de la lista y el tamaño de la misma (antes y después de agregar a
en la primera y última posición)*/

import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio2_2 {
    public static void main(String[] args) throws Exception {
        int [] numeros = {2,3,4,5};
        int long_orig = numeros.length;
        
        int long_nuevo = long_orig+2;
        int [] nueva_lista = new int [long_nuevo];
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el valor inicial: ");
        int inicio = scan.nextInt();
        System.out.println("Ingrese el valor final: ");
        int fin = scan.nextInt();
        scan.close();

        nueva_lista[0] = inicio;
        
        for (int i = 0; i < numeros.length; i++){
            nueva_lista[i+1] = numeros[i];
        }

        nueva_lista[long_orig+1] = fin;

        System.out.println("Tamaño antes: "+ long_orig);
        System.out.println("Tamaño ahora: "+ long_nuevo);
        System.out.println("Array nuevo:\n"+ Arrays.toString(nueva_lista));
    }
}