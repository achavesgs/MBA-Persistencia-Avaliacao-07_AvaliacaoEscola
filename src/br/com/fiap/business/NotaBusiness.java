package br.com.fiap.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Nota;
import br.com.fiap.helper.NotaHelper;
import br.com.fiap.helper.AlunoHelper;

public class NotaBusiness {
	
	public void incluirNota(Nota nota) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AvaliacaoEscola");
		EntityManager em = emf.createEntityManager();
		
		NotaHelper helper = new NotaHelper(em);
		
		JOptionPane.showMessageDialog(null, helper.salvar(nota));
		
	}
}
