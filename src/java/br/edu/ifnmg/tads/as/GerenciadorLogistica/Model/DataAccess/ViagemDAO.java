package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Viagem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
@Stateless
public class ViagemDAO extends DAOGenerico<Viagem> {

    //Constructor...............................................................
    public ViagemDAO() {
        super(Viagem.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Viagem> Buscar(Viagem obj) {
        String Consulta = "select l from Viagem l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }

}
