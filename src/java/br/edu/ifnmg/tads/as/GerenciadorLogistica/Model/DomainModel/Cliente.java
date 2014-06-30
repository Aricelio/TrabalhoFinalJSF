

package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author celio
 */
@Entity
@Table(name = "Clientes")
public class Cliente extends Pessoa implements Serializable {
    
    
}
