package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Curso;

public class CursoHelper {
	private EntityManager em;
	
	public CursoHelper(EntityManager em) {
	this.em = em;
	}
	
	public String salvar(Curso curso) {
		try {
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
			return "Curso incluído com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public String adicionarAlunoCurso(int idCurso, Nota alunoCurso) {
		try {
			Curso curso = em.find(Curso.class, idCurso);
			alunoCurso.setCurso(curso);
			curso.getNotas().add(alunoCurso);
			em.getTransaction().begin();
			em.persist(curso);
			em.getTransaction().commit();
			return "Curso atualizado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	public Curso buscarCursoPorNome(String nomeCurso){
		TypedQuery<Curso> query = em.createQuery("Select p from Curso p Where p.nome = :nomeCurso", Curso.class);
		query.setParameter("nomeCurso", nomeCurso);
		return query.getSingleResult();
	}
	
	public Curso buscarCursoPorId(int idCurso){
		TypedQuery<Curso> query = em.createQuery("Select p from Curso p Where p.id = :idCurso", Curso.class);
		query.setParameter("idCurso", idCurso);
		return query.getSingleResult();
	}
	
	public List<Curso> listarCursos(){
		TypedQuery<Curso> query = em.createQuery("Select e from Curso e", Curso.class);
		return query.getResultList();
	}
	
	public List<Nota> listarAlunosCursos(int idCurso){
		TypedQuery<Nota> query = em.createQuery("Select p from AlunoCurso p Where p.curso.id = :idcurso", Nota.class);
		query.setParameter("idcurso", idCurso);
		return query.getResultList();
	}
	
}
