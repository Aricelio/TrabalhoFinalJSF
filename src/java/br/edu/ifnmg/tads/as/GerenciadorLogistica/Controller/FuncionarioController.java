package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.FuncionarioDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Funcionario;
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
@Named(value = "funcionarioController")
@SessionScoped
public class FuncionarioController implements Serializable {

    @EJB
    FuncionarioDAO funcionarioDAO;

    private Funcionario entidade, filtro;

    private List<Funcionario> listagem;

    private Email email;
    private Telefone telefone;
    private Endereco endereco;

    //Constructor................................................................
    public FuncionarioController() {
        entidade = new Funcionario();
        filtro = new Funcionario();
        email = new Email();
        telefone = new Telefone();
        endereco = new Endereco();
    }

    //Method AutoCompletar......................................................
    public List<Funcionario> autoCompletar(String texto) {
        Funcionario tmp = new Funcionario();
        tmp.setNome(texto);
        return funcionarioDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = funcionarioDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new Funcionario();
        return "editarFuncionario.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    //Method Salvar.............................................................
    public void salvar() {
        if (funcionarioDAO.Salvar(entidade)) {
            exibirMensagem("Salvo");
    
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String apagar() {        
        String retorno = "";
        if (funcionarioDAO.Apagar(entidade)) {
            exibirMensagem("Registro apagado com sucesso!");
            retorno = "listagemFuncionario.xhtml";
            filtrar();
            return retorno;
        } else {
            exibirMensagem("Falha ao apagar registro!");
            return retorno;
        }
    }

    //Getters e Setters.........................................................
    public Funcionario getEntidade() {
        return entidade;
    }

    public void setEntidade(Funcionario entidade) {
        this.entidade = entidade;
    }

    public List<Funcionario> getListagem() {
        if (listagem == null) {
            listagem = funcionarioDAO.Buscar(null);
        }
        return listagem;
    }

    public Funcionario getFiltro() {
        return filtro;
    }

    public void setFiltro(Funcionario filtro) {
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

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    //Method for Addition.......................................................
    public void addTelefone() {        
        try{
            entidade.addTelefone(telefone);        
            exibirMensagem("Telefone adicionado com sucesso!");
            telefone = new Telefone();
        } 
        catch(Exception ex) {
            exibirMensagem("Falha ao adicionar telefone!");
        }
    }

    public void addEndereco() {        
        try{
            entidade.addEndereco(endereco);
            exibirMensagem("Endereço adicionado com sucesso!");
            endereco = new Endereco();
        } 
        catch(Exception ex){
            exibirMensagem("Falha ao adicionar Endereço!");
        }
    }

    public void addEmail() {
        try{
            entidade.addEmail(email);        
            exibirMensagem("Email adicionado com sucesso!");
            email = new Email();
        } 
        catch(Exception ex){
            exibirMensagem("Falha ao adicionar Email!");
        }
    }

    //Methods for removal.......................................................
    public void removeEndereco() {
        try{
            entidade.removeEndereco(endereco);        
            exibirMensagem("Endereço removido com sucesso!");
            endereco = new Endereco();
        }
        catch(Exception ex){
            exibirMensagem("Falha ao remover Email!");
        }
    }

    public void removeTelefone() {
        try{
            entidade.removeTelefone(telefone);        
            exibirMensagem("Telefone removido com sucesso!");
            telefone = new Telefone();
        } 
        catch(Exception ex) {
            exibirMensagem("Falha ao remover Telefone!");
        }
    }

    public void removeEmail() {
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
