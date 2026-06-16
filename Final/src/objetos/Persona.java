package objetos;

import java.io.Serializable;
import java.util.Objects;

public abstract class Persona implements Serializable, Comparable <Persona> {

    private int dni;
    private String nombre;
    private String apellido;
    
    public Persona() {
    }

    public Persona(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    // metodos 

    public abstract void mostrarInfo();

    //compareTo
    public int compareTo(Persona otraPersona){
        return this.apellido.compareTo(otraPersona.apellido);
    }

    //
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }


    //equals
    @Override
    public 
}

