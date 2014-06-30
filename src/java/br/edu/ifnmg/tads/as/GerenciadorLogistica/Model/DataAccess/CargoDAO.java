package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cargo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author celio
 */

@Stateless
public class CargoDAO extends DAOGenerico<Cargo> {

    //Constructor...............................................................
    public CargoDAO() {
        super(Cargo.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Cargo> Buscar(Cargo obj) {
        String Consulta = "select l from Cargo l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
