package ar.com.ada.nasa.nasachallenge.repos;

import org.springframework.stereotype.Repository;

import ar.com.ada.nasa.nasachallenge.entities.Pais;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer>{

}