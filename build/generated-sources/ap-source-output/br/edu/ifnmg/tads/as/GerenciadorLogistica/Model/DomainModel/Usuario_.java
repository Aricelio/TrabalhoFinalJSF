package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Funcionario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-30T16:02:02")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, Long> id;
    public static volatile SingularAttribute<Usuario, Funcionario> funcionario;
    public static volatile SingularAttribute<Usuario, String> login;

}