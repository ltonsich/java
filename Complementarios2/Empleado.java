/*Se dispone de una lista de Empleados, de cada empleado se conoce: Nombre y Apellido, DNI, horasTrabajadas, valorPorHora
Todos los empleados están cargados en un Set (HashSet), se desea calcular el sueldo (horasTrabajadas x valorPorHora) de toda esa lista para luego almacenar en un Map (o Diccionario) donde la clave (key) es el dni y el valor (value) es el sueldo calculado.*/

public class Empleado {
    private String nombreApellido;
    private String dni;
    private int horasTrabajadas;
    private double valorHora;

    Empleado(String nombap, String dni, int horasTrabajadas,double valorHora){
this.nombreApellido = nombap;
this.dni = dni;
this.horasTrabajadas= horasTrabajadas;
this.valorHora=valorHora;
    }

    public void info(){
        System.out.println(this.nombreApellido + " - DNI : "+ this.dni + " - Horas Trabajadas : "+this.horasTrabajadas + " - Valor Hora : " + this.valorHora);
    }

    public double getTotalPagar(){
        return this.horasTrabajadas*this.valorHora;
    }

    public String getDni(){
        return this.dni;
    }   
}