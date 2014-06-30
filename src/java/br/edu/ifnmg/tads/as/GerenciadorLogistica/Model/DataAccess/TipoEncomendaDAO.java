package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.TipoEncomenda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
@Stateless
public class TipoEncomendaDAO extends DAOGenerico<TipoEncomenda> {

    //Constructor...............................................................
    public TipoEncomendaDAO() {
        super(TipoEncomenda.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<TipoEncomenda> Buscar(TipoEncomenda obj) {
        String Consulta = "select l from TipoEncomenda l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
