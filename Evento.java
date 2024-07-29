/*
 * 
 * @autor Juan Jose Rivas Alvarez
 * @date 2024-07-2024
 * 
 */

import java.util.Date;

public class Evento {
    private String nombre;
    private int capacidadTotal;
    private Localidad[] localidades;
    private Date fechaVenta;


    public Evento(String nombre, int capacidadTotal, Localidad[] localidades, Date fechaVenta) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.localidades = localidades;
        this.fechaVenta = fechaVenta;
    }

    public void configElementos(String nombre, int capacidadTotal, Localidad[] localidades, Date fechaVenta) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.localidades = localidades;
        this.fechaVenta = fechaVenta;
    }

    public Localidad[] getLocalidades() {
        return this.localidades;
    }

    public Date getFechaVenta(){
        return this.fechaVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    

 }