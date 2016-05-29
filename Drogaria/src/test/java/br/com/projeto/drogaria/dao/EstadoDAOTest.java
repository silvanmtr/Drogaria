/**
 * 
 */
package br.com.projeto.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.drogaria.entidade.Estado;

/**
 * @author Silvan de Jesus
 *
 */
public class EstadoDAOTest {
	@Test
	@Ignore
	public void Salvar() {
		Estado estado = new Estado();

		estado.setNome("Minas Gerais");
		estado.setSigla("MG");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println("Nome: " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(codigo);

		System.out.println(estado.getNome());

	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			estadoDAO.excluir(estado);
		}
		
	}
	
	@Test 
	public void editar(){
		Long codigo = 1L;

		EstadoDAO estadoDAO = new EstadoDAO();

		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			estado.setNome("Minas Gerais");
			estadoDAO.editar(estado);
		}
		
	}

}
