/*Crear una lista que contenga como elementos la numeración de cartas de una baraja francesa (solo los valores, no figuras).
Se deberá cargar el ArrayList (en orden), imprimir, imprimir en orden inverso (reverse), desordenar (mezclar) el arrayList y volver a imprimir*/

import java.util.Arrays;
import java.util.Random;

public class Ejercicio2_3 {
    public static void main(String[] args) throws Exception {
        int [] cartas = {2,3,4,5,6,7,8,9,10};
        System.out.println("Cartas ordenadas: " + Arrays.toString(cartas));
        System.out.println("Cartas invertidas: " + Arrays.toString(invertir(cartas)));
        System.out.println("Cartas mezcladas: " + Arrays.toString(mezclar(cartas)));
        
    }

    public static int[] invertir(int [] valores){
        int longitud = valores.length;
        int [] inv = new int[longitud]; 
        for (int i = longitud; i >0 ; i --){
            inv[i-1] = valores[longitud-i];
        }
        return inv;
    }

    public static int[] mezclar(int[] valores)
    {
        int index, temp;
        int [] array = valores;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}