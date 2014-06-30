package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.CargoDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cargo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author celio
 */
@Named(value = "cargoController")
@SessionScoped
public class CargoController implements Serializable {

    @EJB
    CargoDAO cargoDAO;
    
    private Cargo entidade, filtro;
    
    private List<Cargo> listagem;
    
    //Constructor................................................................
    public CargoController() {
        entidade = new Cargo();
        filtro = new Cargo();
    }
    
    //Method AutoCompletar......................................................
    public List<Cargo> autoCompletar(String texto) {
        Cargo tmp = new Cargo();
        tmp.setNome(texto);
        return cargoDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = cargoDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new Cargo();
        return "editarCargo.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    
    //Method Salvar.............................................................
    public void salvar() {
        if (cargoDAO.Salvar(entidade)) {
            exibirMensagem("Salvo");
            entidade = new Cargo();
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String Apagar() {
        String r = "";

        if (cargoDAO.Apagar(entidade)) {
            r = "listagemCargo.xhtml";
            return r;
        } else {
            return r;
        }
    }
    
    //Getters e Setters.........................................................
    public Cargo getEntidade() {
        return entidade;
    }

    public void setEntidade(Cargo entidade) {
        this.entidade = entidade;
    }

    public List<Cargo> getListagem() {
        if (listagem == null) {
            listagem = cargoDAO.Buscar(entidade);
        }
        return listagem;
    }

    public Cargo getFiltro() {
        return filtro;
    }

    public void setFiltro(Cargo filtro) {
        this.filtro = filtro;
    }
    
}
