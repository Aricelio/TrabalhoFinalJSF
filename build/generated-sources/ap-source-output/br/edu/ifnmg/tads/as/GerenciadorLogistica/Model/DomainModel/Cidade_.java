package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Rota;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-02T14:08:53")
@StaticMetamodel(Cidade.class)
public class Cidade_ { 

    public static volatile SingularAttribute<Cidade, String> estado;
    public static volatile SingularAttribute<Cidade, String> nome;
    public static volatile SingularAttribute<Cidade, Long> id;
    public static volatile SingularAttribute<Cidade, Rota> rota;

}