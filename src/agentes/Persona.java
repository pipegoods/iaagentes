/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author pipem
 */
public class Persona implements Serializable{
    private String id;
    private String nombre;
    private String fecnac;
    private String genero;
    private ArrayList<String> lista_telefonos;


    public Persona(String id, String nombre, String fecnac, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.fecnac = fecnac;
        this.genero = genero;
        lista_telefonos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<String> getLista_telefonos() {
        return lista_telefonos;
    }

    public void setLista_telefonos(ArrayList<String> lista_telefonos) {
        this.lista_telefonos = lista_telefonos;
    }

    public void agregarTelefono (String tel){
        this.lista_telefonos.add(tel);
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", fecnac=" + fecnac + ", genero=" + genero + ", lista_telefonos=" + lista_telefonos + '}';
    }
    
      
}
