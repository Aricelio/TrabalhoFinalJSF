package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.CentroDistribuicaoDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.CentroDistribuicao;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Email;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Endereco;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Telefone;
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
@Named(value = "centroDistribuicaoController")
@SessionScoped
public class CentroDistribuicaoController implements Serializable {

    @EJB
    CentroDistribuicaoDAO centroDistribuicaoDAO;
    
    private CentroDistribuicao entidade, filtro;
    
    private List<CentroDistribuicao> listagem;
    
    private Email email;
    private Telefone telefone;
    private Endereco endereco;
    
    //Constructor................................................................
    public CentroDistribuicaoController() {
        entidade = new CentroDistribuicao();
        filtro = new CentroDistribuicao();
        endereco = new Endereco();
        email = new Email();
        telefone = new Telefone();
    }
    
    //Method AutoCompletar......................................................
    public List<CentroDistribuicao> autoCompletar(String texto) {
        CentroDistribuicao tmp = new CentroDistribuicao();
        tmp.setNome(texto);
        return centroDistribuicaoDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = centroDistribuicaoDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new CentroDistribuicao();
        return "editarCentroDistribuicao.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    
    //Method Salvar.............................................................
    public void salvar() {
        if (centroDistribuicaoDAO.Salvar(entidade)) {
            exibirMensagem("Salvo");
            entidade = new CentroDistribuicao();
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String Apagar() {
        String r = "";

        if (centroDistribuicaoDAO.Apagar(entidade)) {
            r = "listagemCentroDistribuicao.xhtml";
            return r;
        } else {
            return r;
        }
    }
    
    //Getters e Setters.........................................................
    public CentroDistribuicao getEntidade() {
        return entidade;
    }

    public void setEntidade(CentroDistribuicao entidade) {
        this.entidade = entidade;
    }

    public List<CentroDistribuicao> getListagem() {
        if (listagem == null) {
            listagem = centroDistribuicaoDAO.Buscar(null);
        }
        return listagem;
    }

    public CentroDistribuicao getFiltro() {
        return filtro;
    }

    public void setFiltro(CentroDistribuicao filtro) {
        this.filtro = filtro;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    //Method for Add............................................................
    public void addTelefone(){
        try{
            entidade.addTelefone(telefone);        
            exibirMensagem("Telefone adicionado com sucesso!");
            telefone = new Telefone();
        } 
        catch(Exception ex) {
            exibirMensagem("Falha ao adicionar telefone!");
        }
    }
    
    public void addEndereco(){
        try{
            entidade.addEndereco(endereco);
            exibirMensagem("Endereço adicionado com sucesso!");
            endereco = new Endereco();
        } 
        catch(Exception ex){
            exibirMensagem("Falha ao adicionar Endereço!");
        }
    }
    
    public void addEmail(){
        try{
            entidade.addEmail(email);        
            exibirMensagem("Email adicionado com sucesso!");
            email = new Email();
        } 
        catch(Exception ex){
            exibirMensagem("Falha ao adicionar Email!");
        }
    }
    
    //Methods for remove........................................................
    public void removeEndereco(){
        try{
            entidade.removeEndereco(endereco);        
            exibirMensagem("Endereço removido com sucesso!");
            endereco = new Endereco();
        }
        catch(Exception ex){
            exibirMensagem("Falha ao remover Email!");
        }
    }
    
    public void removeTelefone(){
        try{
            entidade.removeTelefone(telefone);        
            exibirMensagem("Telefone removido com sucesso!");
            telefone = new Telefone();
        } 
        catch(Exception ex) {
            exibirMensagem("Falha ao remover Telefone!");
        }
    }
     
   public void removeEmail(){
        try{
            entidade.removeEmail(email);
            exibirMensagem("Email removido com sucesso!");
            email = new Email();
        }
        catch(Exception ex){
            exibirMensagem("Falha ao remover Email!");
        }
    } 
    
}
