package br.com.projeto.drogaria.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * @author Silvan de Jesus
 *
 */
@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}