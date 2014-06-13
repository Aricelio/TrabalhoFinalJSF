package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
public class UsuarioDAO extends DAOGenerico<Usuario> {

    //Constructor...............................................................
    public UsuarioDAO() {
        super(Usuario.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Usuario> Buscar(Usuario obj) {
        String Consulta = "select l from Usuario l";
        if (obj != null) {
            Consulta = Consulta + " where l.login like '%" + obj.getLogin()+ "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
}
