/**
 * 
 */
package br.com.projeto.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.com.projeto.drogaria.entidade.Cliente;
import br.com.projeto.drogaria.entidade.Pessoa;

/**
 * @author Silvan de Jesus
 *
 */
public class ClienteDAOTest {

	@Test
	public void salvar() throws ParseException{
		Long codigoPessoa = 1L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2013"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		if(pessoa == null){
			System.out.println("Selecione uma pessoa");			
		}else{
			clienteDao.salvar(cliente);
		}
		
	}
}
