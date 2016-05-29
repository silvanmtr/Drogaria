package br.com.projeto.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.projeto.drogaria.entidade.Cidade;
import br.com.projeto.drogaria.entidade.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {
		EstadoDAO estadoDao = new EstadoDAO();

		Estado estado = estadoDao.buscar(1L);

		Cidade cidade = new Cidade();

		cidade.setNome("Montes Claros");
		cidade.setEstado(estado);

		CidadeDAO cidadeDao = new CidadeDAO();

		cidadeDao.salvar(cidade);
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDao = new CidadeDAO();

		List<Cidade> resultado = cidadeDao.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Cidade: " + cidade.getNome() + "\n Estado: "
					+ cidade.getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		CidadeDAO cidadeDao = new CidadeDAO();
		Cidade cidade = cidadeDao.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Cidade: " + cidade.getNome() + "\nEstado: "
					+ cidade.getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		CidadeDAO cidadeDao = new CidadeDAO();
		Cidade cidade = cidadeDao.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			cidadeDao.excluir(cidade);
		}
	}

	@Test
	public void editar() {
		Long codigo = 3L;
		
		EstadoDAO estadoDao = new EstadoDAO();

		Estado estado = estadoDao.buscar(3L);

		CidadeDAO cidadeDao = new CidadeDAO();
		Cidade cidade = cidadeDao.buscar(codigo);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			cidade.setNome("Monte Rei");
			cidade.setEstado(estado);

			cidadeDao.editar(cidade);

		}
	}

}
