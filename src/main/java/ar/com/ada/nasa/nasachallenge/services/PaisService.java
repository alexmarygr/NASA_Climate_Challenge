package ar.com.ada.nasa.nasachallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.nasa.nasachallenge.entities.Pais;
import ar.com.ada.nasa.nasachallenge.repos.PaisRepository;

@Service
public class PaisService {

    @Autowired
    PaisRepository repositorioPais;

	public void crearPais(int codigoPais, String nombre) {
        Pais pais = new Pais();
        pais.setPaisId(codigoPais);
        pais.setNombre(nombre);
        repositorioPais.save(pais);
	}

	public List<Pais> listarPaises() {
		return repositorioPais.findAll();
    }
    
    public Pais buscarPorId(int codigoPais){ 
       
        Optional<Pais> pais = repositorioPais.findById(codigoPais);

        if(pais.isPresent()){
            
            return pais.get();
        }
        return null;
    }

    public void modificarNombrePais(Pais pais, String nuevoNombre){

        pais.setNombre(nuevoNombre);

        repositorioPais.save(pais);
    }
}