/**
 * 
 */
package br.com.projeto.drogaria.dao;

import org.junit.Test;

import br.com.projeto.drogaria.entidade.Pessoa;
import br.com.projeto.drogaria.entidade.Usuario;

/**
 * @author Silvan de Jesus
 *
 */
public class UsuarioDAOTest {

	@Test
	public void salvar(){
		Long codigoPessoa = 1L;
		
		PessoaDAO pessoaDao = new PessoaDAO();
		Pessoa pessoa = pessoaDao.buscar(codigoPessoa);
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("123");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(pessoa == null){
			System.out.println("Registro não encontrado");			
		}else{
			usuarioDao.salvar(usuario);
		}
	}
}
