package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Curso;

public class AlunoHelper {
	private EntityManager em;
	
	public AlunoHelper(EntityManager em) {
	this.em = em;
	}
	
	public String salvar(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
			return "Aluno incluído com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String adicionarNota(int idAluno, Nota nota) {
		try {
			Aluno aluno = em.find(Aluno.class, idAluno);
			nota.setAluno(aluno);
			aluno.getNotas().add(nota);
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
			return "Aluno atualizado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public Aluno buscarAlunoPorId(int idAluno){
		TypedQuery<Aluno> query = em.createQuery("Select p from Aluno p Where p.id = :idAluno", Aluno.class);
		query.setParameter("idAluno", idAluno);
		return query.getSingleResult();
	}
	
	public List<Aluno> listarAlunos(){
		TypedQuery<Aluno> query = em.createQuery("Select e from Aluno e", Aluno.class);
		return query.getResultList();
	}
	
	public List<Nota> listarAlunosCursos(int idAluno){
		TypedQuery<Nota> query = em.createQuery("Select p from AlunoCurso p Where p.aluno.id = :idaluno", Nota.class);
		query.setParameter("idaluno", idAluno);
		return query.getResultList();
	}
	
}
