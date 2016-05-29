/**
 * 
 */
package br.com.projeto.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.projeto.drogaria.entidade.Fabricante;
import br.com.projeto.drogaria.entidade.Produto;

/**
 * @author Silvan de Jesus
 * Classe de testes do Produto.
 *
 */
public class ProdutoDAOTest {
	
	@Test
	public void salvar(){
		
		Long codigoFabricante = 1L;
		
		FabricanteDAO fabricanteDao = new FabricanteDAO();
		
		Fabricante fabricante = fabricanteDao.buscar(codigoFabricante);
		
		Produto produto = new Produto();
		produto.setDescricao("Cataflan com 10 comprimidos");
		produto.setPreco(new BigDecimal("15.70"));
		produto.setQuantidade(new Short("7"));
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDao = new ProdutoDAO();
		
		if(fabricante == null){
			System.out.println("Selecione um fabricante");
		}else{
			produtoDao.salvar(produto);	
		}
		
	}

}
