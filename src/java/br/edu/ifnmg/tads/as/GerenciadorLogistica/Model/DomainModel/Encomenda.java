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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author celio
 */
@Entity
@Table(name = "Encomendas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Encomenda implements Serializable {
    
    //Attributes................................................................
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EncomendaID")
    private Long id;
    
    @Column(length = 50)
    private String nome;
    
    @Column(length = 50)
    private String descricao;
    
    private Double peso;
    
    private Double preco;
    
    @ManyToOne
    private TipoEncomenda tipo;
    
    @ManyToOne
    private CategoriaEncomenda categoria;
    
    @ManyToOne
    private Retorno retorno;
    
    @ManyToOne
    private Destino destino;
    
    @ManyToOne
    private Cliente cliente;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TipoEncomenda getTipo() {
        return tipo;
    }

    public void setTipo(TipoEncomenda tipo) {
        this.tipo = tipo;
    }

    public CategoriaEncomenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEncomenda categoria) {
        this.categoria = categoria;
    }

    public Retorno getRetorno() {
        return retorno;
    }

    public void setRetorno(Retorno retorno) {
        this.retorno = retorno;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    //Equals and hashCode.......................................................
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + Objects.hashCode(this.peso);
        hash = 23 * hash + Objects.hashCode(this.preco);
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
        final Encomenda other = (Encomenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.peso, other.peso)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
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
