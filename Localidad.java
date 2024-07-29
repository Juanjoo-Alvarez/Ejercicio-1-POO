/*
 * 
 * @autor Juan Jose Rivas Alvarez
 * @date 2024-07-2024
 * 
 */

public class Localidad {
    private String nombre;
    private int capacidad;
    private int boletosVendidos;
    private int precio;


    public Localidad(String nombre, int capacidad, int precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.boletosVendidos = 0;
        this.precio = precio;
    }

    public boolean validarEspacio(int cantidad) {
        return (this.capacidad - this.boletosVendidos) >= cantidad;
    }

    public void venderBoletos(int cantidad) {
        this.boletosVendidos += cantidad;
    }

    public int getBoletosDisponibles() {
        return this.capacidad - this.boletosVendidos;
    }

    public int getPrecio() {
        return this.precio;
    }

    public String getNombre() {
        return this.nombre;
    }
    
}
