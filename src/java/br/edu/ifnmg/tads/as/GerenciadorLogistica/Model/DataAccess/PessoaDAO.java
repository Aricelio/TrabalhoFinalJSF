

package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Pessoa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author celio
 */
public class PessoaDAO extends DAOGenerico<Pessoa>{

    //Constructor...............................................................
    public PessoaDAO() {
        super(Pessoa.class);
    }

    //Method Find "Pessoa"......................................................
    @Override
    public List<Pessoa> Buscar(Pessoa obj) {
        String consulta = "select l from Pessoa l";
        
        if(obj != null){
            consulta = consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        
        Query q = manager.createQuery(consulta);
        return q.getResultList();
    }
}
