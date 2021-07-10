package br.com.renato.loja.dao;

import java.util.List;

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
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> listarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

}
