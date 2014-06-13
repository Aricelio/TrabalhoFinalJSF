

package br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAOGenerico<T> {
    @PersistenceContext(name="TrabalhoFinalJSFPU")
    protected EntityManager manager;
    private Class tipo;
    public DAOGenerico (Class t) {
        tipo = t;
    }
    
    //Method Save...............................................................
    public boolean Salvar(T obj) {
        try{
            //salva o objeto
            manager.merge(obj);
            return true;
        }catch (Exception ex){
        System.out.println(ex.getMessage());
        return false;
        }
    }
    
    //Method Open...............................................................    
    public T Abrir(Long id) {
        try {
            T obj = (T) manager.find(tipo, id);
            return obj;            
        } catch (Exception ex) {
            return null;
        }
    }
    
    //Method Find...............................................................
    public abstract List<T> Buscar(T obj);    
    
    //Method Delete.............................................................   
    public boolean Apagar(T obj) {
        try {
            manager.remove(manager.merge(obj));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}