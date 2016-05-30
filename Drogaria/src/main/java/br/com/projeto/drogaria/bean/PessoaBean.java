/**
 * 
 */
package br.com.projeto.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.projeto.drogaria.dao.CidadeDAO;
import br.com.projeto.drogaria.dao.EstadoDAO;
import br.com.projeto.drogaria.dao.PessoaDAO;
import br.com.projeto.drogaria.entidade.Cidade;
import br.com.projeto.drogaria.entidade.Estado;
import br.com.projeto.drogaria.entidade.Pessoa;

/**
 * @author Silvan de Jesus
 *
 */

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable{
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private Estado estado;
	
	
	private List<Estado> estados;
	private List<Cidade> cidades;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	@PostConstruct
	public void listar(){
		try {
			PessoaDAO pessoaDao = new PessoaDAO();
			pessoas = pessoaDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
			e.printStackTrace();
		}
	}
	
	public void novo(){
		pessoa = new Pessoa();
		
		EstadoDAO estadoDao = new EstadoDAO();
		estados = estadoDao.listar();
		
		cidades = new ArrayList<Cidade>();
		
	}
	
	public void salvar(){
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);
			
			pessoas = pessoaDAO.listar("nome");
			
			pessoa = new Pessoa();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

			cidades = new ArrayList<>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
			erro.printStackTrace();
		}
	}
	
	public void popular(){
			try {
				if(estado != null){
					CidadeDAO cidadeDao = new CidadeDAO();
					cidades = cidadeDao.buscarPorEstado(estado.getCodigo());
				} else{
					cidades = new ArrayList<Cidade>();
				}
				
			} catch (RuntimeException e) {
				e.printStackTrace();
				Messages.addGlobalError("Ocorreu um erro ao tentar listar as cidades");
			}
	}

}
