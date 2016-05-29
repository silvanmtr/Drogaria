/**
 * 
 */
package br.com.projeto.drogaria.entidade;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Silvan de Jesus
 * Classe de definição de todas as chaves primárias nas tabelas
 *
 */

@SuppressWarnings("serial")
//Essa classe não corresponde à uma tabela, mas será usada por outras classes para definir a chave primária
@MappedSuperclass
public class GenericDomain implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
