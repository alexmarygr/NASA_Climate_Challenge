package ar.com.ada.nasa.nasachallenge.entities;

import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="temperatura")
public class Temperatura {
    @Id
    @Column(name="temperatura_id")
    private int temperatura;
    @Column(name="temperatura_anio")
    private int anio;
    private BigDecimal grados;
    @ManyToOne
    @JoinColumn(name="codigo_pais", referencedColumnName = "codigo_pais")
    @JsonIgnore
    private Pais pais;

    public int getTemperaturaId() {
        return temperatura;
    }

    public void setTemperaturaId(int temperaturaId) {
        this.temperatura = temperaturaId;
    }

    public int getTemperaturaAnio() {
        return anio;
    }

    public void setTemperaturaAnio(int anioTemp) {
        anio = anioTemp;
    }

    public BigDecimal getGrados() {
        return grados;
    }

    public void setGrados(BigDecimal grados) {
        this.grados = grados;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
        this.pais.getTemperaturas().add(this);
    }

    

}