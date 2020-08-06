package ar.com.ada.nasa.nasachallenge.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.ada.nasa.nasachallenge.entities.Pais;
import ar.com.ada.nasa.nasachallenge.entities.Temperatura;
import ar.com.ada.nasa.nasachallenge.models.request.TempRequest;
import ar.com.ada.nasa.nasachallenge.models.response.TemperaturaResponse;
import ar.com.ada.nasa.nasachallenge.repos.TemperaturaRepository;
import ar.com.ada.nasa.nasachallenge.services.PaisService;
import ar.com.ada.nasa.nasachallenge.services.TemperaturaService;

@Controller
public class TemperaturaController {

    @Autowired
    TemperaturaRepository tempRepo;
    
    @Autowired
    TemperaturaService tempService;

    @Autowired
    PaisService paisService;

    @PostMapping("/temperaturas")
    public ResponseEntity<?> crearTemperatura(@RequestBody TempRequest temp){

        TemperaturaResponse response = new TemperaturaResponse();

        tempService.crearTemp(temp.codigoPais,temp.anio,temp.grados);

        response.isOk = true;
        response.message = "Cargaste la temperatura exitosamente";

        return ResponseEntity.ok(response);
    }

    @GetMapping("/temperaturas/paises/{codigoPais}")
    public ResponseEntity<?> getTemperaturasPorPais(@PathVariable int codigoPais){
        Pais pais = paisService.buscarPorId(codigoPais);
        return ResponseEntity.ok(tempService.listarTemperaturasPais(pais));
    }

    @DeleteMapping("/temperaturas/{id}")
    public ResponseEntity<?> borrarTemperatura(@PathVariable int id){
        Temperatura temp = tempService.buscarPorId(id);
        temp.setGrados(new BigDecimal(0));
        tempRepo.save(temp);
        TemperaturaResponse response = new TemperaturaResponse();
        response.isOk = true;
        response.message = "Borraste la temperatura exitosamente";
        return ResponseEntity.ok(response);
        
    }

}