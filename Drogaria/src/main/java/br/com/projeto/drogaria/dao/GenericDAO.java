package br.com.projeto.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.projeto.drogaria.util.HibernateUtil;

/**
 * 
 * @author Silvan de Jesus
 *
 */

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * 
	 * @param e
	 * Método  que salva um objeto no banco
	 */
	public void salvar(Entidade e) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(e);
			transacao.commit();

		} catch (RuntimeException excessao) {
			if (transacao != null) {
				transacao.rollback();
			}
			// Propaga o erro para as camadas superiores
			throw excessao;
		} finally {
			sessao.close();
		}

	}

	/**
	 * Método que lista os objetos de uma entidade
	 * 
	 * @return
	 */
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			Criteria consulta = sessao.createCriteria(classe);
			@SuppressWarnings("unchecked")
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException excessao) {
			throw excessao;
		} finally{
			sessao.close();
		}
	}
	
	/**
	 * Método que lista os objetos de uma entidade
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {			
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			
			Entidade resultado = (Entidade)consulta.uniqueResult();
			
			return resultado;
		} catch (RuntimeException excessao) {
			throw excessao;
		} finally{
			sessao.close();
		}
	}
	
	/**
	 * 
	 * @param e
	 * Método  que exclui um objeto no banco
	 */
	public void excluir(Entidade e) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(e);
			transacao.commit();

		} catch (RuntimeException excessao) {
			if (transacao != null) {
				transacao.rollback();
			}
			// Propaga o erro para as camadas superiores
			throw excessao;
		} finally {
			sessao.close();
		}

	}
	
	
	/**
	 * 
	 * @param e
	 * Método  que edita um objeto no banco
	 */
	public void editar(Entidade e) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(e);
			transacao.commit();

		} catch (RuntimeException excessao) {
			if (transacao != null) {
				transacao.rollback();
			}
			// Propaga o erro para as camadas superiores
			throw excessao;
		} finally {
			sessao.close();
		}

	}

}
