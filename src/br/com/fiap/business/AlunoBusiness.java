package br.com.fiap.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.helper.AlunoHelper;
import br.com.fiap.helper.CursoHelper;

public class AlunoBusiness {
	
	public void incluirAluno(Aluno aluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();
		
		AlunoHelper helper = new AlunoHelper(em);
		
		JOptionPane.showMessageDialog(null, helper.salvar(aluno));
		
	}
	
	public Aluno buscarAlunoPorId(int idAluno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();

		AlunoHelper helper = new AlunoHelper(em);

		return helper.buscarAlunoPorId(idAluno);
	}
	

	public List<Aluno> listarAlunos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();

		AlunoHelper helper = new AlunoHelper(em);
		
		return helper.listarAlunos();

	}
}
