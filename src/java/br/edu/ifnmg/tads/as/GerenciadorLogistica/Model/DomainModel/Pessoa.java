package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
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
        this.enderecos = new ArrayList<Endereco>();
        this.telefones = new ArrayList<Telefone>();
        this.emails = new ArrayList<Email>();
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

    @Column(length = 20)
    private String sexo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Email> emails;

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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    //Method addTelefone........................................................    
    public void addTelefone(Telefone t) {
        t.setPessoa(this);
        if (telefones == null) {
            telefones = new ArrayList<Telefone>();
        }
        if (!telefones.contains(t)) {
            telefones.add(t);
        }
    }

    public void removeTelefone(Telefone t) {
        if (telefones.contains(t)) {
            telefones.remove(t);
        }
    }

    //Method addEmail...........................................................
    public void addEmail(Email e) {
        e.setPessoa(this);
        if (emails == null) {
            emails = new ArrayList<Email>();
        }
        if (!emails.contains(e)) {            
            emails.add(e);
        }
    }

    public void removeEmail(Email e) {
        if (emails.contains(e)) {
            emails.remove(e);
        }
    }

    //Method addEndereco........................................................
    public void addEndereco(Endereco e) {
        e.setPessoa(this);
        if (enderecos == null) {
            enderecos = new ArrayList<Endereco>();
        }
        if (!enderecos.contains(e)) {
            enderecos.add(e);
        }
    }

    public void removeEndereco(Endereco e) {
        if (enderecos.contains(e)) {
            enderecos.remove(e);
        }
    }

    //Equals and HashCode.......................................................
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.dataNascimento);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.rg);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.enderecos);
        hash = 97 * hash + Objects.hashCode(this.telefones);
        hash = 97 * hash + Objects.hashCode(this.emails);
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
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
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
