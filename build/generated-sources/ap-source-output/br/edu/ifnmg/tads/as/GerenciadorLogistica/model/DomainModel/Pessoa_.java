package br.edu.ifnmg.tads.as.GerenciadorLogistica.model.DomainModel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-05T09:39:27")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> rg;
    public static volatile SingularAttribute<Pessoa, String> cpf;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile SingularAttribute<Pessoa, Long> id;
    public static volatile SingularAttribute<Pessoa, Date> dataNascimento;

}