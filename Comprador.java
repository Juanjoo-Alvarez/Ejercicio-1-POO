/*
 * 
 * @autor Juan Jose Rivas Alvarez
 * @date 2024-07-2024
 * 
 */

public class Comprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private int presupusto;

    
    public Comprador(String nombre, String email, int cantidadBoletos, int presupusto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupusto = presupusto;
    }


    public int getCantidadBoletos() {
        return cantidadBoletos;
    }


    public int getPresupusto() {
        return presupusto;
    }


    public String getNombre() {
        return nombre;
    }


    public String getEmail() {
        return email;
    }
    
     
    
}
