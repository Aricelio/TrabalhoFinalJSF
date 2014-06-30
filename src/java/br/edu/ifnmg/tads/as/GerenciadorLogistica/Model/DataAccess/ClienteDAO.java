package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
@Stateless
public class ClienteDAO extends DAOGenerico<Cliente> {
    //Constructor...............................................................
    public ClienteDAO() {
        super(Cliente.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Cliente> Buscar(Cliente obj) {
        String Consulta = "select l from Cliente l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
