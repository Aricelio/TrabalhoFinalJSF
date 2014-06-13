package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Rota;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
public class RotaDAO extends DAOGenerico<Rota> {

    //Constructor...............................................................
    public RotaDAO() {
        super(Rota.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Rota> Buscar(Rota obj) {
        String Consulta = "select l from Rota l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
