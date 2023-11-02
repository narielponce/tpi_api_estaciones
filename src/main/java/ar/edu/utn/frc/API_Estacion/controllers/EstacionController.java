package ar.edu.utn.frc.API_Estacion.controllers;

import ar.edu.utn.frc.API_Estacion.dtos.AddNuevaEstacionDTO;
import ar.edu.utn.frc.API_Estacion.dtos.EstacionDTO;
import ar.edu.utn.frc.API_Estacion.services.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class EstacionController {
    @Autowired
    EstacionService estacionService;

    @GetMapping (value = "/api/estaciones")
    public ResponseEntity<List<EstacionDTO>> findAll() {
        List<EstacionDTO> estacionList = estacionService.findAll();
        return ResponseEntity.ok(estacionList);
    }

    @GetMapping(value = "/api/estacion/{id}")
    public ResponseEntity<EstacionDTO> getTaskById(@PathVariable Long id){
        EstacionDTO estacion = estacionService.findById(id);

        if (estacion != null) {
            return ResponseEntity.ok(estacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/api/nuevaestacion")
    public ResponseEntity<AddNuevaEstacionDTO> createStation(@RequestBody AddNuevaEstacionDTO addNuevaEstacionDTO) {
        AddNuevaEstacionDTO createdEstacion = estacionService.save(addNuevaEstacionDTO);
        return ResponseEntity.ok(createdEstacion);
    }

    @GetMapping (value = "/api/estacion" )
    public ResponseEntity<EstacionDTO> findNearestStation(@RequestParam double lat1, @RequestParam double lon1){
        EstacionDTO estacionDTO = estacionService.encontrarEstacionCercana(lat1, lon1);
        return ResponseEntity.ok(estacionDTO);
    }

    @GetMapping (value = "/api/distanciaestaciones")
    public Double distanciaEntreEstaciones (@RequestParam long e1, @RequestParam long e2){
        Double distancia = estacionService.distanciaEntreEstaciones(e1, e2);
        return distancia;
    }

    @PutMapping (value = "/api/estacion/{id}")
    public ResponseEntity<AddNuevaEstacionDTO> updateStation(@PathVariable Long id, @RequestBody AddNuevaEstacionDTO addNuevaEstacionDTO) {
        AddNuevaEstacionDTO updatedStation = estacionService.update(id, addNuevaEstacionDTO);
        if (updatedStation != null) {
            return ResponseEntity.ok(updatedStation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/api/estacion/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Long id) {
        estacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
