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
    
    Email email;
    Telefone telefone;
    Endereco endereco;
    
    //Constructor................................................................
    public FuncionarioController() {
        entidade = new Funcionario();
        filtro = new Funcionario();
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
            entidade = new Funcionario();
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String Apagar() {
        String r = "";

        if (funcionarioDAO.Apagar(entidade)) {
            r = "listagemFuncionario.xhtml";
            return r;
        } else {
            return r;
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
    
    
    //Method for Add............................................................
    public void addTelefone(){
        //entidade = funcionarioDAO.Refresh(entidade.getId());
        entidade.addTelefone(telefone);
        funcionarioDAO.Salvar(entidade);
        telefone = new Telefone();
    }
    
    public void addEndereco(){
        entidade.addEndereco(endereco);
        funcionarioDAO.Salvar(entidade);
        endereco = new Endereco();
    }
    
    public void addEmail(){
        entidade.addEmail(email);
        funcionarioDAO.Salvar(entidade);
        email = new Email();
    }
    
    //Methods for remove........................................................
    public void removeEndereco(){
        entidade.removeEndereco(endereco);
        funcionarioDAO.Salvar(entidade);
        endereco = new Endereco();
    }
    
    public void removeTelefone(){
        entidade.removeTelefone(telefone);
        funcionarioDAO.Salvar(entidade);
        telefone = new Telefone();
    }
     
   public void removeEmail(){
        entidade.removeEmail(email);
        funcionarioDAO.Salvar(entidade);
        email = new Email();
    } 
    
}
