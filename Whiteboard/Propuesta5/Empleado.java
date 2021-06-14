/*Ejercicio Propuesto #5: Dado un archivo de texto (.txt) con el formato:
{nombre},{apellido},{fecha de nacimiento},{sueldo}*/

package Whiteboard.Propuesta5;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado implements Comparable<Empleado>{
    private String nombre ; 
    private String apellido ;
    private LocalDate fechaNac ;
    private double sueldo ;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    Empleado(String nombre , String apellido , LocalDate fechaNac , double sueldo){
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNac = fechaNac;
        this.sueldo=sueldo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setFechaNac(LocalDate fechaNac){        
        this.fechaNac = fechaNac;
    }

    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }

    public String getApellido(){
        return apellido;
    }

    public String getNombre(){
        return nombre;
    }

    public LocalDate getFechaNac(){
        return fechaNac;
    }

    public double getSueldo() {
        return sueldo;
    }

    public int calcularEdad(){
        LocalDate fecha_actual = LocalDate.now();
        int edad = 0;
        
        if (this.getFechaNac().getMonth().compareTo(fecha_actual.getMonth())<0 ){
            edad= fecha_actual.getYear() -  this.getFechaNac().getYear();
            }

        else if(this.getFechaNac().getMonth().compareTo(fecha_actual.getMonth())==0){
            if (this.getFechaNac().getDayOfMonth()>fecha_actual.getDayOfMonth()){
                edad= fecha_actual.getYear() -  this.getFechaNac().getYear() -1;
                }
            else{
                edad= fecha_actual.getYear() -  this.getFechaNac().getYear();
                }
        }
        else{
            edad= fecha_actual.getYear() -  this.getFechaNac().getYear() -1;
            } 

        return edad;
    }

    @Override
    public int compareTo(Empleado o2){
        if (this.nombre.compareTo(o2.getNombre())>0){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString(){
        return "{ Nombre :  "+ this.nombre + " | Apellido :  "+ this.apellido + " | Fecha de Nacimiento : "+ this.fechaNac.format(this.formatter) + " | Sueldo "+ this.sueldo+ " | Edad : "+ this.calcularEdad()+ " }";
    }
}