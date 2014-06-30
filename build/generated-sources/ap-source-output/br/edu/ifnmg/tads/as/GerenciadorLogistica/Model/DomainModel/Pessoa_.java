package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Email;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Endereco;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Telefone;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-30T16:02:02")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile ListAttribute<Pessoa, Email> emails;
    public static volatile SingularAttribute<Pessoa, String> rg;
    public static volatile ListAttribute<Pessoa, Endereco> enderecos;
    public static volatile SingularAttribute<Pessoa, String> cpf;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Long> id;
    public static volatile SingularAttribute<Pessoa, Date> dataNascimento;
    public static volatile SingularAttribute<Pessoa, String> sexo;
    public static volatile ListAttribute<Pessoa, Telefone> telefones;

}