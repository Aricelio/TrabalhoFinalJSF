

package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author celio
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Pessoas")
public class Pessoa implements Serializable {
    
    //Constructor...............................................................
     public Pessoa() {
        this.endereco = new ArrayList<Endereco>();
        this.telefone = new ArrayList<Telefone>();
        this.email = new ArrayList<Email>();
    }


    //Attributes................................................................
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PessoaID")
    private Long id;
    
    @Column(length = 50)
    private String nome;
   
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    
    @Column(length = 14) 
    private String cpf; 

    @Column(length = 20) 
    private String rg; 

    @Column(length = 1)
    private String sexo;
    
    @OneToMany
    private List<Endereco> endereco;
    
    @OneToMany
    private List<Telefone> telefone;
    
    @OneToMany
    private List<Email> email;
    
      
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
    //Method addTelefone........................................................    
    public void addTelefone(Telefone t){
        if(telefone == null)
            telefone = new ArrayList<Telefone>();
        if(!telefone.contains(t)){
            telefone.add(t);
        }
        
    }
    
    public void removeTelefone(Telefone t){
        if(telefone.contains(t)){
            telefone.remove(t);
        }
    }
    
    
    //Method addEmail...........................................................
    public void addEmail(Email e){
        if(email == null)
            email = new ArrayList<Email>();
        if(!email.contains(e)){
            email.add(e);
        }
        
    }
    
    public void removeEmail(Email e){
        if(email.contains(e)){
            email.remove(e);
        }
    }
    
    //Method addEndereco........................................................
    public void addEndereco(Endereco e){
        if(endereco == null){
            endereco = new ArrayList<Endereco>();
        }
        if(!endereco.contains(e)){
            endereco.add(e);
        }
    }
    
    public void removeEndereco(Endereco e){
        if(endereco.contains(e)){
            endereco.remove(e);
        }
    }
    
    //Equals and HashCode.......................................................
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.dataNascimento);
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.rg);
        hash = 83 * hash + Objects.hashCode(this.sexo);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
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
