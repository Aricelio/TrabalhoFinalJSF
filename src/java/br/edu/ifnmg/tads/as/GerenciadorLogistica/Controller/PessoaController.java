package br.edu.ifnmg.tads.as.GerenciadorLogistica.Controller;

import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.as.GerenciadorLogistica.Model.DomainModel.Pessoa;
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
@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable {

    @EJB
    PessoaDAO pessoaDAO;

    private Pessoa entidade, filtro;

    private List<Pessoa> listagem;

    private Email email;
    private Telefone telefone;
    private Endereco endereco;

    //Constructor................................................................
    public PessoaController() {
        entidade = new Pessoa();
        filtro = new Pessoa();
        email = new Email();
        telefone = new Telefone();
        endereco = new Endereco();
    }

    //Method AutoCompletar......................................................
    public List<Pessoa> autoCompletar(String texto) {
        Pessoa tmp = new Pessoa();
        tmp.setNome(texto);
        return pessoaDAO.Buscar(tmp);
    }

    //Method Filtrar............................................................
    public void filtrar() {
        listagem = pessoaDAO.Buscar(filtro);
    }

    //Method Novo...............................................................
    public String novo() {
        entidade = new Pessoa();
        return "editarPessoa.xhtml";
    }

    //Method ExibirMensagem.....................................................
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }

    //Method Salvar.............................................................
    public void salvar() {
        if (pessoaDAO.Salvar(entidade)) {
            exibirMensagem("Salvo");
            entidade = new Pessoa();
        } else {
            exibirMensagem("Erro!");
        }
    }

    //Method Apagar.............................................................
    public String Apagar() {
        String r = "";

        if (pessoaDAO.Apagar(entidade)) {
            r = "listagemPessoa.xhtml";
            return r;
        } else {
            return r;
        }
    }

    //Getters e Setters.........................................................
    public Pessoa getEntidade() {
        return entidade;
    }

    public void setEntidade(Pessoa entidade) {
        this.entidade = entidade;
    }

    public List<Pessoa> getListagem() {
        if (listagem == null) {
            listagem = pessoaDAO.Buscar(null);
        }
        return listagem;
    }

    public Pessoa getFiltro() {
        return filtro;
    }

    public void setFiltro(Pessoa filtro) {
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

    public PessoaDAO getPessoaDAO() {
        return pessoaDAO;
    }

    public void setPessoaDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    //Method for Addition.......................................................
    public void addTelefone() {
        entidade.addTelefone(telefone);
        if (pessoaDAO.Salvar(entidade)) {
            exibirMensagem("Telefone adicionado com sucesso!");
            telefone = new Telefone();
        } else {
            exibirMensagem("Falha ao adicionar telefone!");
        }
    }

    public void addEndereco() {
        entidade.addEndereco(endereco);
        if(pessoaDAO.Salvar(entidade)){
            exibirMensagem("Endereço adicionado com sucesso!");
            endereco = new Endereco();
        } else {
            exibirMensagem("Falha ao adicionar Endereço!");
        }
    }

    public void addEmail() {
        entidade.addEmail(email);
        if(pessoaDAO.Salvar(entidade)){
            exibirMensagem("Email adicionado com sucesso!");
            email = new Email();
        } else {
            exibirMensagem("Falha ao adicionar Email!");
        }
    }

    //Methods for removal.......................................................
    public void removeEndereco() {
        entidade.removeEndereco(endereco);
        if(pessoaDAO.Salvar(entidade)){
            exibirMensagem("Endereço removido com sucesso!");
            endereco = new Endereco();
        } else {
            exibirMensagem("Falha ao remover Email!");
        }
    }

    public void removeTelefone() {
        entidade.removeTelefone(telefone);
        if(pessoaDAO.Salvar(entidade)){
            exibirMensagem("Telefone removido com sucesso!");
            telefone = new Telefone();
        } else {
            exibirMensagem("Falha ao remover Telefone!");
        }
    }

    public void removeEmail() {
        entidade.removeEmail(email);
        if(pessoaDAO.Salvar(entidade)){
            exibirMensagem("Email removido com sucesso!");
            email = new Email();
        } else {
            exibirMensagem("Falha ao remover Email!");
        }
    }
}
