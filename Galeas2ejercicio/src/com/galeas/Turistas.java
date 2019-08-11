package com.galeas;
import com.galeas.excepciones.ErrorValidacion;

public class Turistas {


    public int contador = 1;
    public String nombre;
    public String telefono;

    public int getContador() {
        return contador;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getNombre() {
        return nombre;
    }


    public void setContador(int contador) {
        this.contador += contador;
    }

    public void setTelefono(String telefono) throws ErrorValidacion{
        if (!telefono.matches("^[0-9]{4}\\-[0-9]{4}")) {
            throw new ErrorValidacion("El numero del telefono se excede de lo establecido ");
        }
        this.telefono = telefono;
    }
    public void setNombre(String nombre) throws ErrorValidacion {
        if (nombre.length() > 50){
            throw new ErrorValidacion("El limite sugerido para el nombre son de 50 caracteres! ");
        }
        this.nombre = nombre;
    }




}

