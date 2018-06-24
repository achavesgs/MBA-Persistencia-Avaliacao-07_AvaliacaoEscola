package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Curso;

public class NotaHelper {
	private EntityManager em;
	
	public NotaHelper(EntityManager em) {
	this.em = em;
	}
	
	public String salvar(Nota nota) {
		try {
			em.getTransaction().begin();
			em.persist(nota);
			em.getTransaction().commit();
			return "Nota incluída com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
		
	public List<Nota> listarNotas(){
		TypedQuery<Nota> query = em.createQuery("Select e from Nota e", Nota.class);
		return query.getResultList();
	}
	
}
