package ar.edu.utn.frc.API_Estacion.repositories;

import ar.edu.utn.frc.API_Estacion.models.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Long> {

}
