package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.ClienteDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Cliente;
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
@Named(value = "clienteController")
@SessionScoped
public class ClienteController implements Serializable {

    @EJB
    ClienteDAO clienteDAO;

    private Cliente entidade, filtro;

    private List<Cliente> listagem;

    private Email email;
    private Telefone telefone;
    private Endereco endereco;

    //Constructor................................................................
    public ClienteController() {
        entidade = new Cliente();
        filtro = new Cliente();
        email = new Email();
        telefone = new Telefone();
        endereco = new Endereco();
    }

    //Method AutoCompletar......................................................
    public List<Cliente> autoCompletar(String texto) {
        Cliente tmp = new Cliente();
        tmp.setNome(texto);
        return clienteDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = clienteDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new Cliente();
        return "editarCliente.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    //Method Salvar.............................................................
    public void salvar() {
        if (clienteDAO.Salvar(entidade)) {
            exibirMensagem("Salvo");
            entidade = new Cliente();
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String Apagar() {
        String r = "";

        if (clienteDAO.Apagar(entidade)) {
            r = "listagemCliente.xhtml";
            return r;
        } else {
            return r;
        }
    }

    //Getters e Setters.........................................................
    public Cliente getEntidade() {
        return entidade;
    }

    public void setEntidade(Cliente entidade) {
        this.entidade = entidade;
    }

    public List<Cliente> getListagem() {
        if (listagem == null) {
            listagem = clienteDAO.Buscar(null);
        }
        return listagem;
    }

    public Cliente getFiltro() {
        return filtro;
    }

    public void setFiltro(Cliente filtro) {
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
    public void addTelefone() {
        entidade.addTelefone(telefone);
        if (clienteDAO.Salvar(entidade)) {
            exibirMensagem("Telefone adicionar com sucesso!");
            telefone = new Telefone();
        }
        else{
            exibirMensagem("Falha ao adicionar o telefone");
        }
    }

    public void addEndereco() {
        entidade.addEndereco(endereco);
        if (clienteDAO.Salvar(entidade)) {
            exibirMensagem("Endereço adicionado com sucesso!");
            endereco = new Endereco();
        } else {
            exibirMensagem("Falha ao adicionar o Endereço");
        }
    }

    public void addEmail() {
        entidade.addEmail(email);
        if (clienteDAO.Salvar(entidade)) {
            exibirMensagem("Email adicionado com sucesso!");
            email = new Email();
        } else {
            exibirMensagem("Falha ao adicionar email!");
        }
    }

    //Methods for remove........................................................
    public void removeEndereco() {
        entidade.removeEndereco(endereco);
        clienteDAO.Salvar(entidade);
        endereco = new Endereco();
    }

    public void removeTelefone() {
        entidade.removeTelefone(telefone);
        clienteDAO.Salvar(entidade);
        telefone = new Telefone();
    }

    public void removeEmail() {
        entidade.removeEmail(email);
        if (clienteDAO.Salvar(entidade)) {
            exibirMensagem("Email removido com sucesso!");
            email = new Email();
        } else {
            exibirMensagem("Falha ao remover email!");
        }
    }
}
