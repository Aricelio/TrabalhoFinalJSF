package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author celio
 */
@Entity
@Table(name = "Destinos")
public class Destino extends Endereco implements Serializable {    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DestinoID")
    private Long id;
    
    //Getters e Setter..........................................................
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
       
    //Equals e HashCode.........................................................
    @Override    
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Destino other = (Destino) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
