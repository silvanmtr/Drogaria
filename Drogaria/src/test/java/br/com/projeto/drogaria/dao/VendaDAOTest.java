/**
 * 
 */
package br.com.projeto.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.com.projeto.drogaria.entidade.Cliente;
import br.com.projeto.drogaria.entidade.Funcionario;
import br.com.projeto.drogaria.entidade.Venda;

/**
 * @author Silvan de Jesus
 *
 */
public class VendaDAOTest {
	
	@Test
	public void salvar() throws ParseException{
		Long codigoCliente = 1L;
		Long codigoFuncionario = 1L;
		
		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = clienteDao.buscar(codigoCliente);
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDao.buscar(codigoFuncionario);
		
		VendaDAO vendaDao = new VendaDAO();
		Venda venda = new Venda();
		
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setHorario(new SimpleDateFormat("dd/MM/yyyy").parse("25/03/2013"));
		venda.setPrecoTotal(new BigDecimal("150.56"));
		
		if(cliente == null || funcionario == null){
			System.out.println("Nenhum registro selecionado");
		}else{
			vendaDao.salvar(venda);
		}			
	}

}
