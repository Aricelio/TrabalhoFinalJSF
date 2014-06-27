

package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.CentroDistribuicao;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
public class CentroDistribuicaoDAO extends DAOGenerico<CentroDistribuicao> {
   
    
    //Constructor...............................................................
    public CentroDistribuicaoDAO() {
        super(CentroDistribuicao.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<CentroDistribuicao> Buscar(CentroDistribuicao obj) {
        String Consulta = "select l from CentroDistribuicao l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
    
}
