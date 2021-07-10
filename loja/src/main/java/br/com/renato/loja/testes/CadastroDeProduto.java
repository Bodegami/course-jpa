package br.com.renato.loja.testes;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import br.com.renato.loja.dao.CategoriaDao;
import br.com.renato.loja.dao.ProdutoDao;
import br.com.renato.loja.modelo.Categoria;
import br.com.renato.loja.modelo.Produto;
import br.com.renato.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Categoria celulares = new Categoria("celulares");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		// Abre uma transacao com DB, faz a persistencia do objeto, comita a transacao e
		// fecha a transacao
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();

	}

}
