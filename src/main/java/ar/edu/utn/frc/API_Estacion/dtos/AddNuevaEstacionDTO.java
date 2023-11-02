package ar.edu.utn.frc.API_Estacion.dtos;

import lombok.Data;

@Data
public class AddNuevaEstacionDTO {
    private String nombre;
    private double latitud;
    private double longitud;
}
