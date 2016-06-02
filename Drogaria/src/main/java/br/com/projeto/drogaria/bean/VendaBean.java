/**
 * 
 */
package br.com.projeto.drogaria.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.projeto.drogaria.dao.ProdutoDAO;
import br.com.projeto.drogaria.entidade.ItemVenda;
import br.com.projeto.drogaria.entidade.Produto;
import br.com.projeto.drogaria.entidade.Venda;

/**
 * @author Silvan de Jesus
 *
 */

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {
	private List<Produto> produtos;
	private List<ItemVenda> itensVenda;

	private Venda venda;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@PostConstruct
	public void novo() {
		try {
			venda = new Venda();
			venda.setPrecoTotal(new BigDecimal(0.00));

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar("descricao");
			itensVenda = new ArrayList<>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar a tela de vendas");
			erro.printStackTrace();
		}
	}

	public void adicionar(ActionEvent evento) {
		Produto produto = (Produto) evento.getComponent().getAttributes()
				.get("produtoSelecionado");

		int achou = -1;

		// Percorre o ArrayList de Produtos
		for (int i = 0; i < itensVenda.size(); i++) {
			// Verifica se o produto a ser adicionado já existe no ArrayList
			if (itensVenda.get(i).getProduto().equals(produto)) {
				achou = i;
			}
		}

		if (achou < 0) {
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setPrecoParcial(produto.getPreco());
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("1"));

			itensVenda.add(itemVenda);
		} else {
			// Caso já exista um produto é atualizado a quantidade
			ItemVenda itemVenda = itensVenda.get(achou);
			itemVenda.setQuantidade(new Short(itemVenda.getQuantidade() + 1
					+ ""));
			itemVenda.setPrecoParcial(produto.getPreco().multiply(
					new BigDecimal(itemVenda.getQuantidade())));
		}
		calcular();
	}

	public void remover(ActionEvent evento) {
		ItemVenda itemVenda = (ItemVenda) evento.getComponent().getAttributes()
				.get("itemSelecionado");

		int achou = -1;

		// Percorre o ArrayList de Produtos
		for (int posicao = 0; posicao < itensVenda.size(); posicao++) {
			// Verifica se o produto a ser adicionado já existe no ArrayList
			if (itensVenda.get(posicao).getProduto()
					.equals(itemVenda.getProduto())) {
				achou = posicao;
			}
		}

		if (achou > -1) {
			itensVenda.remove(achou);
		}
		calcular();
	}

	public void calcular() {
		venda.setPrecoTotal(new BigDecimal(0.00));

		for (int i = 0; i < itensVenda.size(); i++) {
			ItemVenda itemVenda = itensVenda.get(i);
			venda.setPrecoTotal(venda.getPrecoTotal().add(
					itemVenda.getPrecoParcial()));
		}
	}
}
