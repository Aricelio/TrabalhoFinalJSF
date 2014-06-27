package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.CentroDistribuicao;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Funcionario;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Rota;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Veiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-06-26T20:10:53")
@StaticMetamodel(Viagem.class)
public class Viagem_ { 

    public static volatile SingularAttribute<Viagem, Veiculo> veiculo;
    public static volatile SingularAttribute<Viagem, Date> horaChegada;
    public static volatile SingularAttribute<Viagem, CentroDistribuicao> centroDistribuicao;
    public static volatile SingularAttribute<Viagem, Date> horaSaida;
    public static volatile SingularAttribute<Viagem, String> nome;
    public static volatile SingularAttribute<Viagem, Long> id;
    public static volatile SingularAttribute<Viagem, Funcionario> funcionario;
    public static volatile SingularAttribute<Viagem, Rota> rota;

}