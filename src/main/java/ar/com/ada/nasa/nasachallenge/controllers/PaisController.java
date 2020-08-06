package ar.com.ada.nasa.nasachallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.nasa.nasachallenge.entities.Pais;
import ar.com.ada.nasa.nasachallenge.models.request.PaisRequest;
import ar.com.ada.nasa.nasachallenge.models.request.UpdatePaisRequest;
import ar.com.ada.nasa.nasachallenge.repos.PaisRepository;
import ar.com.ada.nasa.nasachallenge.services.PaisService;

@Controller
public class PaisController {

    @Autowired
    PaisService servicioPais;

    @Autowired
    PaisRepository paisRepository;

    @PostMapping("/paises")
    public ResponseEntity<?> crearPais(@RequestBody PaisRequest pais){
        servicioPais.crearPais(pais.codigoPais,pais.nombre);
        return ResponseEntity.ok(pais);
    }

    @GetMapping("/paises")
    public ResponseEntity<?> getPaises(){
        return ResponseEntity.ok(servicioPais.listarPaises());
    }

    @GetMapping("/paises/{id}")
    public ResponseEntity<?> getPaisPorId(@PathVariable int id){
        return ResponseEntity.ok(servicioPais.buscarPorId(id));
    }

    @PutMapping("/paises/{id}")
    public ResponseEntity<?> actualiarNombrePaisPorId(@PathVariable int id, 
    @RequestBody UpdatePaisRequest newNamePais){
        Pais pais = servicioPais.buscarPorId(id);
        servicioPais.modificarNombrePais(pais, newNamePais.nombre);
        return ResponseEntity.ok(pais);
    }

}