package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.RotaDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cidade;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Rota;
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
@Named(value = "rotaController")
@SessionScoped
public class RotaController implements Serializable {

    @EJB
    RotaDAO rotaDAO;
    
    private Rota entidade, filtro;
    
    private List<Rota> listagem;
    
    private Cidade cidade;
    
    //Constructor................................................................
    public RotaController() {
        entidade = new Rota();
        filtro = new Rota();
        cidade = new Cidade();
    }
    
    //Method AutoCompletar......................................................
    public List<Rota> autoCompletar(String texto) {
        Rota tmp = new Rota();
        tmp.setNome(texto);
        return rotaDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = rotaDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new Rota();
        return "editarRota.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    
    //Method Salvar.............................................................
    public void salvar() {
        if (rotaDAO.Salvar(entidade)) {
            exibirMensagem("Salvo");
            entidade = new Rota();
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String apagar() {
        String r = "";

        if (rotaDAO.Apagar(entidade)) {
            r = "listagemRota.xhtml";
            return r;
        } else {
            return r;
        }
    }
    
    //Method addCidade..........................................................
    public void addCidade() {        
        try{
            entidade.addCidade(cidade);        
            exibirMensagem("Cidade adicionado com sucesso!");
            cidade = new Cidade();
        } 
        catch(Exception ex) {
            exibirMensagem("Falha ao adicionar cidade!");
        }
    }
    
    //Method removeCidade.......................................................
    public void removeCidade() {
        try{
            entidade.removeCidade(cidade);        
            exibirMensagem("Endereço removido com sucesso!");
            cidade = new Cidade();
        }
        catch(Exception ex){
            exibirMensagem("Falha ao remover Email!");
        }
    }
    
    //Getters e Setters.........................................................
    public Rota getEntidade() {
        return entidade;
    }

    public void setEntidade(Rota entidade) {
        this.entidade = entidade;
    }

    public List<Rota> getListagem() {
        if (listagem == null) {
            listagem = rotaDAO.Buscar(entidade);
        }
        return listagem;
    }

    public Rota getFiltro() {
        return filtro;
    }

    public void setFiltro(Rota filtro) {
        this.filtro = filtro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
