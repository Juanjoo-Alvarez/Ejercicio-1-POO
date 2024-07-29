/*
 * 
 * @autor Juan Jose Rivas Alvarez
 * @date 2024-07-2024
 * 
 */

public class Boleto {
    private String numero;
    private Comprador comprador;


    public Boleto(String numero, Comprador comprador) {
        this.numero = numero;
        this.comprador = comprador;
    }

    public String getNumero() {
        return this.numero;
    }

    public Comprador getComprador(){
        return  this.comprador;
    }
}
