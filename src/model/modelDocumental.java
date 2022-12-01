/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Miguel
 */
public class modelDocumental {
    private int id;
    private String titulo;
    private String nombre;
    private String apellido;
    private String origen;
    private int anio;
    
    public modelDocumental(int id,String titulo,String nombre,String apellido,String origen,int anio){
        this.id = id;
        this.titulo=titulo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anio=anio;
        this.origen=origen;
        
    }

    public modelDocumental(String titulo, String nombre, String apellido, String origen, int anio) {
        this.titulo=titulo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anio=anio;
        this.origen=origen;    
    }

    public modelDocumental(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    public String getTitulo(){
        return titulo;
    }
     public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public Object[] toArray(){
        Object[] data = {id, titulo, nombre, apellido, origen, anio};
        return data;
    }

    /**
     * @param titulo the titulo to set
     */
   
}
