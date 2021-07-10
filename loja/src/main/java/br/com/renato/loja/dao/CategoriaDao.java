package br.com.renato.loja.dao;

import javax.persistence.EntityManager;

import br.com.renato.loja.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;
	
	// Design Pattern DAO
	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}

}
