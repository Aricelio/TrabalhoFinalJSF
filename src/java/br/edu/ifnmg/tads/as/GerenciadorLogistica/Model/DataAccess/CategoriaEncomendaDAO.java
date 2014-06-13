package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.CategoriaEncomenda;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
public class CategoriaEncomendaDAO extends DAOGenerico<CategoriaEncomenda> {

    //Constructor...............................................................
    public CategoriaEncomendaDAO() {
        super(CategoriaEncomenda.class);
    }

    //Method 'Buscar'...........................................................
    @Override
    public List<CategoriaEncomenda> Buscar(CategoriaEncomenda obj) {
        String Consulta = "select l from CategoriaEncomenda l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
