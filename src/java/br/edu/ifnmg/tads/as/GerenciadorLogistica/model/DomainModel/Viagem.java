package br.edu.ifnmg.tads.as.GerenciadorLogistica.model.DomainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author celio
 */
@Entity
@Table(name = "Viagens")
@Inheritance(strategy = InheritanceType.JOINED)
public class Viagem implements Serializable {
    
    //Attributes................................................................
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ViagemID")
    private Long id;

    @Column(length = 50)
    private String nome;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSaida;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaChegada;
    
    @ManyToOne
    private Veiculo veiculo;
    
    @ManyToOne
    private CentroDistribuicao centroDistribuicao;
    
    @ManyToOne
    private Funcionario funcionario;
    
    @ManyToOne
    private Rota rota;    
    
    
    //Getters and Setters.......................................................
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

    public Date getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Date horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Date getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Date horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public CentroDistribuicao getCentroDistribuicao() {
        return centroDistribuicao;
    }

    public void setCentroDistribuicao(CentroDistribuicao centroDistribuicao) {
        this.centroDistribuicao = centroDistribuicao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
    
    //Equals and hashCode.......................................................
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.horaSaida);
        hash = 79 * hash + Objects.hashCode(this.horaChegada);
        hash = 79 * hash + Objects.hashCode(this.veiculo);
        hash = 79 * hash + Objects.hashCode(this.centroDistribuicao);
        hash = 79 * hash + Objects.hashCode(this.funcionario);
        hash = 79 * hash + Objects.hashCode(this.rota);
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
        final Viagem other = (Viagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.horaSaida, other.horaSaida)) {
            return false;
        }
        if (!Objects.equals(this.horaChegada, other.horaChegada)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        if (!Objects.equals(this.centroDistribuicao, other.centroDistribuicao)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.rota, other.rota)) {
            return false;
        }
        return true;
    }
    
    //toString..................................................................
    @Override
    public String toString() {
        return nome;
    }
    
}
