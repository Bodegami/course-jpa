package br.com.renato.loja.testes;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import br.com.renato.loja.dao.ProdutoDao;
import br.com.renato.loja.modelo.Produto;
import br.com.renato.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);

		// Abre uma transacao com DB, faz a persistencia do objeto, comita a transacao e
		// fecha a transacao
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();

	}

}
