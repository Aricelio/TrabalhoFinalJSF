package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.CategoriaEncomenda;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cliente;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Destino;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Retorno;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.TipoEncomenda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-01T14:35:23")
@StaticMetamodel(Encomenda.class)
public class Encomenda_ { 

    public static volatile SingularAttribute<Encomenda, Double> preco;
    public static volatile SingularAttribute<Encomenda, Cliente> cliente;
    public static volatile SingularAttribute<Encomenda, TipoEncomenda> tipo;
    public static volatile SingularAttribute<Encomenda, Retorno> retorno;
    public static volatile SingularAttribute<Encomenda, Double> peso;
    public static volatile SingularAttribute<Encomenda, CategoriaEncomenda> categoria;
    public static volatile SingularAttribute<Encomenda, String> nome;
    public static volatile SingularAttribute<Encomenda, Long> id;
    public static volatile SingularAttribute<Encomenda, Destino> destino;
    public static volatile SingularAttribute<Encomenda, String> descricao;

}