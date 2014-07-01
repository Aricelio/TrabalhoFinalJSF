package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.VeiculoDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Veiculo;
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
@Named(value = "veiculoController")
@SessionScoped
public class VeiculoController implements Serializable {

    @EJB
    VeiculoDAO veiculoDAO;
    
    private Veiculo entidade, filtro;
    
    private List<Veiculo> listagem;
    
    //Constructor................................................................
    public VeiculoController() {
        entidade = new Veiculo();
        filtro = new Veiculo();
    }
    
    //Method AutoCompletar......................................................
    public List<Veiculo> autoCompletar(String texto) {
        Veiculo tmp = new Veiculo();
        tmp.setModelo(texto);
        return veiculoDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = veiculoDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new Veiculo();
        return "editarVeiculo.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    
    //Method Salvar.............................................................
    public void salvar() {
        if (veiculoDAO.Salvar(entidade)) {
            exibirMensagem("Veiculo Salvo com Sucesso!");
            entidade = new Veiculo();
        } else {
            exibirMensagem("Erro! Não foi possivel salvar o veiculo!");
        }
    }

    //Method Apagar.............................................................
    public String apagar() {
        String retorno = "";

        if (veiculoDAO.Apagar(entidade)) {
            retorno = "listagemVeiculo.xhtml";
            return retorno;
        } else {
            return retorno;
        }
    }
    
    //Getters e Setters.........................................................
    public Veiculo getEntidade() {
        return entidade;
    }

    public void setEntidade(Veiculo entidade) {
        this.entidade = entidade;
    }

    public List<Veiculo> getListagem() {
        if (listagem == null) {
            listagem = veiculoDAO.Buscar(entidade);
        }
        return listagem;
    }

    public Veiculo getFiltro() {
        return filtro;
    }

    public void setFiltro(Veiculo filtro) {
        this.filtro = filtro;
    }
    
}
