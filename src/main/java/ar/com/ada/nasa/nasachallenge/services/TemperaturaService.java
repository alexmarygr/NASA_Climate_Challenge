package ar.com.ada.nasa.nasachallenge.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nasa.nasachallenge.entities.Pais;
import ar.com.ada.nasa.nasachallenge.entities.Temperatura;
import ar.com.ada.nasa.nasachallenge.repos.TemperaturaRepository;

@Service
public class TemperaturaService {

    @Autowired
    TemperaturaRepository tempRepo;

    @Autowired
    PaisService paisService;


	public void crearTemp(int codigoPais, int anio, BigDecimal grados) {
        
        Temperatura temp = new Temperatura();
        temp.setPais(paisService.buscarPorId(codigoPais));
        temp.setTemperaturaAnio(anio);
        temp.setGrados(grados);
        tempRepo.save(temp);
    }
    
    public List<Temperatura> listarTemperaturasPais(Pais pais){

        List<Temperatura> temperaturasPorPais = new ArrayList();

        temperaturasPorPais = pais.getTemperaturas();

        return temperaturasPorPais;
    }

    public Temperatura buscarPorId(int temperatura){ 
       
        Optional<Temperatura> temp = tempRepo.findById(temperatura);

        if(temp.isPresent()){
            
            return temp.get();
        }
        return null;
    }

}