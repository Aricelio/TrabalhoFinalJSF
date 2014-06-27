

package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Funcionario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
public class FuncionarioDAO extends DAOGenerico<Funcionario> {
   
    
    //Constructor...............................................................
    public FuncionarioDAO() {
        super(Funcionario.class);
    }

    //Method Buscar.............................................................
    @Override
    public List<Funcionario> Buscar(Funcionario obj) {
        String Consulta = "select l from Funcionario l";
        if (obj != null) {
            Consulta = Consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(Consulta);
        return q.getResultList();
    }
    
}
