/*Crear una aplicación que solicite de entrada los datos de una persona en este orden:
Nombre y Apellido, Edad, Dirección, Ciudad, Luego imprimirá el siguiente mensaje:
{Ciudad} - {Dirección} - {Edad} - {Nombre y Apellido}*/

public class Persona {
    private String nombre;
    private String apellido ;
    private int edad;
    private String direccion ;
    private String ciudad ;

    Persona(String nombre , String apellido, int edad , String direccion , String ciudad){
        this.nombre= nombre;
        this.apellido= apellido;
        this.edad= edad;
        this.direccion= direccion;
        this.ciudad= ciudad;
    }
    
    @Override
    public String toString() {
        return " Nombre : " + this.nombre+" - Apellido : "+this.apellido+ " - Edad :" +this.edad+ " - Direccion : "+this.direccion + " - Ciudad : " + this.ciudad ;
        }
}