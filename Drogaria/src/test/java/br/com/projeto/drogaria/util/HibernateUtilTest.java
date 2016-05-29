/**
 * 
 */
package br.com.projeto.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

/**
 * @author Silvan de Jesus
 *
 */
public class HibernateUtilTest {

	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
