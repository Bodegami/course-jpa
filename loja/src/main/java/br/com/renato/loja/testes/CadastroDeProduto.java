package br.com.renato.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.renato.loja.modelo.Produto;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));

		// Design pattern Factory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
		EntityManager em = factory.createEntityManager();

		// Abre uma transacao com DB, faz a persistencia do objeto, comita a transacao e
		// fecha a transacao
		em.getTransaction().begin();
		em.persist(celular);
		em.getTransaction().commit();
		em.close();

	}

}
