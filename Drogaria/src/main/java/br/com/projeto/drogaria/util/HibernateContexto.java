/**
 * 
 */
package br.com.projeto.drogaria.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * @author Silvan de Jesus
 * Classe utilitária utilizada inicializar o Hibernate juntamente com o Tomcat.
 */

public class HibernateContexto implements ServletContextListener {

	/**
	 * @method contextDestroyed
	 * Método de finalização do TomCat
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().close();
	}

	/**
	 * @method contextInitialized
	 * Método de Inicialiazação do TomCat
	 */	

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes();
	}

}