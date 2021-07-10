package br.com.renato.loja.dao;

import javax.persistence.EntityManager;

import br.com.renato.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;
	
	// Design Pattern DAO
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

}
