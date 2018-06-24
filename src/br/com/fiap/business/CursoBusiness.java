package br.com.fiap.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;
import br.com.fiap.helper.AlunoHelper;
import br.com.fiap.helper.CursoHelper;

public class CursoBusiness {

	public void incluirCurso(Curso curso) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();

		CursoHelper helper = new CursoHelper(em);

		JOptionPane.showMessageDialog(null, helper.salvar(curso));

	}

	public List<Curso> listarCursos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();

		CursoHelper helper = new CursoHelper(em);
		
		return helper.listarCursos();

	}

	public static Curso buscarCursoPorNome(String nomeCurso) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();

		CursoHelper helper = new CursoHelper(em);

		return helper.buscarCursoPorNome(nomeCurso);
	}

	public Curso buscarCursoPorId(int idCurso) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();

		CursoHelper helper = new CursoHelper(em);

		return helper.buscarCursoPorId(idCurso);
	}
}
