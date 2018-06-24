package br.com.fiap.app;

import javax.swing.JOptionPane;

import br.com.fiap.business.AlunoBusiness;
import br.com.fiap.business.NotaBusiness;
import br.com.fiap.business.CursoBusiness;
import br.com.fiap.business.EscolaBusiness;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Nota;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;

public class Aplicacao2 {

	public static void main(String[] args) {

		EscolaBusiness escolaBusiness = new EscolaBusiness();
		Escola escola = new Escola();
		CursoBusiness cursoBusiness = new CursoBusiness();
		Curso curso = new Curso();

		Aluno aluno = new Aluno();
		AlunoBusiness alunoBusiness = new AlunoBusiness();
		NotaBusiness notaBusiness = new NotaBusiness();
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Incluir nova escola \n 2- Incluir novo curso"
				+ "\n 3 - incluir novo aluno"));
		
		if(opcao == 1) {
			escola.setNome(JOptionPane.showInputDialog("Nome da Escola"));
				escola.setDataString(JOptionPane.showInputDialog("Data de Fundação"));
				escola.setEndereco(JOptionPane.showInputDialog("Endereço da Escola"));
				escolaBusiness.incluirEscola(escola);
		}else if(opcao == 2) {
			curso.setNome(JOptionPane.showInputDialog("Nome do Curso"));
			escola.setNome(JOptionPane.showInputDialog("Nome da Escola"));
			curso.setEscola(escola);
			cursoBusiness.incluirCurso(curso);
		}else {
			aluno.setNome(JOptionPane.showInputDialog("Nome do Aluno"));
			aluno.setDocumento(JOptionPane.showInputDialog("Documento"));
			aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
			aluno.setTelefone(JOptionPane.showInputDialog("Telefone"));
			alunoBusiness.incluirAluno(aluno);
		}
		 
				
//		Escola escola2 = new Escola();
		

		
//		escola2.setNome(JOptionPane.showInputDialog("Nome da Escola"));
//		escola2.setDataString(JOptionPane.showInputDialog("Data de Fundação"));
//		escola2.setEndereco(JOptionPane.showInputDialog("Endereço da Escola"));
//		escola2.setNome("FIAP 2");
//		escola2.setDataString("18/06/1975");
//		escola2.setEndereco("TESTE2");
//		
////		escolaBusiness.buscarEscola();
////		escolaBusiness.listarTodasEscolas();		
//
//		Curso curso1 = new Curso();
////		curso1.setNome(JOptionPane.showInputDialog("Nome do Curso 1"));
//		curso1.setNome("WEBMODERNA");
//		curso1.setEscola(escola2);
//		
//		Curso curso2 = new Curso();
////		curso2.setNome(JOptionPane.showInputDialog("Nome do Curso 2"));
//		curso2.setNome("PERSISTENCIA");
//		curso2.setEscola(escola2);
//		
//		Nota nota1 = new Nota();
//		nota1.setNota(7.0);
//		nota1.setAluno(aluno);
//		nota1.setCurso(curso1);
//		
//		Nota nota2 = new Nota();
//		nota2.setNota(8.0);
//		nota2.setAluno(aluno);
//		nota2.setCurso(curso2);
//		
//		aluno.getNotas().add(nota1);
//		aluno.getNotas().add(nota2);
//		curso1.getNotas().add(nota1);
//		curso2.getNotas().add(nota2);
//		
//		alunoBusiness.incluirAluno(aluno);
//		cursoBusiness.listarCursos();
////		notaBusiness.incluirNota(nota1);
////		notaBusiness.incluirNota(nota2);
//		
	}

}
