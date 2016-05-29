/**
 * 
 */
package br.com.projeto.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.drogaria.entidade.Estado;
import br.com.projeto.drogaria.entidade.Fabricante;

/**
 * @author Silvan de Jesus
 *
 */
public class FabricanteDAOTest {
	@Test
	@Ignore
	public void Salvar() {
		Fabricante fabricante = new Fabricante();

		fabricante.setDescricao("Fabricado no Brasil");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		for(Fabricante fabricante : resultado){
			System.out.println("Descrição: " + fabricante.getDescricao());
		}
		
	}
	
	@Test
	public void buscar(){
		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		System.out.println(fabricante.getDescricao());

	}

}
