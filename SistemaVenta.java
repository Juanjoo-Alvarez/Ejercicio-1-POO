/*
 * 
 * @autor Juan Jose Rivas Alvarez
 * @date 2024-07-2024
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class SistemaVenta {
    private Evento evento;
    private int correlativo;


    public SistemaVenta(Evento evento) {
        this.evento = evento;
        this.correlativo = 1;
    }

    public void agregarComprador(Comprador comprador, String nombreLocalidad) {
        Localidad localidad = buscarLocalidad(nombreLocalidad);
        if (localidad != null) {
            if (localidad.validarEspacio(comprador.getCantidadBoletos()) && 
                comprador.getPresupusto() >= localidad.getPrecio() * comprador.getCantidadBoletos()) {
                
               
                String numeroBoleto = generarNumeroBoleto();
                
                localidad.venderBoletos(comprador.getCantidadBoletos());
                  
                Boleto boleto = new Boleto(numeroBoleto, comprador);
                
                guardarBoletoEnCSV(boleto, nombreLocalidad);
                
                this.correlativo++;
            }
        }
    }


    public Localidad buscarLocalidad(String nombre) {
        for (Localidad loc : this.evento.getLocalidades()) {
            if (loc.getNombre().equals(nombre)) {
                return loc;
            }
        }
        return null;
    }

    private String generarNumeroBoleto() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String fechaActual = sdf.format(this.evento.getFechaVenta());
        return fechaActual + String.format("%04d", this.correlativo);
    }

    private void guardarBoletoEnCSV(Boleto boleto, String nombreLocalidad) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("boletos.csv", true))) {
            writer.write(boleto.getNumero() + "," + boleto.getComprador().getNombre() + "," + boleto.getComprador().getEmail() + "," + nombreLocalidad);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generarReporteDeCaja() {
        int totalBoletosVendidos = 0;
        int totalDineroRecaudado = 0;

        for (Localidad localidad : this.evento.getLocalidades()) {
            int boletosVendidos = localidad.getBoletosDisponibles();
            int dineroRecaudado = boletosVendidos * localidad.getPrecio();

            totalBoletosVendidos += boletosVendidos;
            totalDineroRecaudado += dineroRecaudado;

            System.out.println("Localidad: " + localidad.getNombre());
            System.out.println("Boletos Vendidos: " + boletosVendidos);
            System.out.println("Dinero Recaudado: Q" + dineroRecaudado);
        }

        System.out.println("\nTotal de Boletos Vendidos: " + totalBoletosVendidos);
        System.out.println("Total de Dinero Recaudado: Q" + totalDineroRecaudado);
    }
}
