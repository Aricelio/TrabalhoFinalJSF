package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author celio
 */
@Entity
@Table(name = "Rotas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Rota implements Serializable {    
    
    //Attributes................................................................
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RotaID")
    private Long id;

    @Column(length = 50)
    private String nome;
    
    private Double distancia;
    
    //Getters and Setter..........................................................
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(int Double) {
        this.distancia = distancia;
    }

    //Equals e HashCode.........................................................
    @Override    
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.distancia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rota other = (Rota) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.distancia, other.distancia)) {
            return false;
        }
        return true;
    }

    //ToString..................................................................
    @Override
    public String toString() {
        return nome;
    }
    
}
