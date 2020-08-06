package ar.com.ada.nasa.nasachallenge.entities;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @Column(name="codigo_pais")
    private int pais;
	private String nombre;
	@OneToMany(mappedBy = "pais",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
    private List<Temperatura> temperaturas = new ArrayList<>();


	public int getPaisId() {
		return pais;
	}
	public void setPaisId(int paisId) {
		this.pais = paisId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Temperatura> getTemperaturas() {
		return temperaturas;
	}

	public void setTemperaturas(List<Temperatura> temperaturas) {
		this.temperaturas = temperaturas;
	}

}