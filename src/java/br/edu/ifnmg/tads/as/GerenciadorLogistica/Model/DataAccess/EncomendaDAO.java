package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Encomenda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
@Stateless
public class EncomendaDAO extends DAOGenerico<Encomenda> {

    //Constructor...............................................................
    public EncomendaDAO() {
        super(Encomenda.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Encomenda> Buscar(Encomenda obj) {
        String Consulta = "select l from Encomenda l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
