package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Veiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
@Stateless
public class VeiculoDAO extends DAOGenerico<Veiculo> {

    //Constructor...............................................................
    public VeiculoDAO() {
        super(Veiculo.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Veiculo> Buscar(Veiculo obj) {
        String Consulta = "select l from Veiculo l";
        if (obj != null) {
            Consulta = Consulta + " where l.modelo like '%" + obj.getModelo() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }

}
