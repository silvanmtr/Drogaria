/**
 * 
 */
package br.com.projeto.drogaria.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

/**
 * @author Silvan de Jesus Classe Bean do Estado responsável pela comunicação
 *         dos dados do model com a view da Classe Estado
 *
 */
@ManagedBean
public class EstadoBean {
	public void salvar() {
		Messages.addGlobalInfo("Programação em Java!");		
	}
}
