package br.com.projeto.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.projeto.drogaria.entidade.Cidade;
import br.com.projeto.drogaria.util.HibernateUtil;
/**
 * @author Silvan de Jesus
 *
 */

public class CidadeDAO extends GenericDAO<Cidade>{

	public List<Cidade> buscarPorEstado(Long estadoCodigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", estadoCodigo));
			consulta.addOrder(Order.asc("nome"));
			
			@SuppressWarnings("unchecked")
			List<Cidade> resultado = consulta.list();
			
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
	}
}
