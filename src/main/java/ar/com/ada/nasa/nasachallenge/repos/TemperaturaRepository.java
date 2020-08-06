package ar.com.ada.nasa.nasachallenge.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.ada.nasa.nasachallenge.entities.Temperatura;


@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura,Integer> {

}