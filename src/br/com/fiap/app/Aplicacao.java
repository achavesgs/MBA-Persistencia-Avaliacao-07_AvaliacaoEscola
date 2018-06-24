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

public class Aplicacao {

	public static void main(String[] args) {

		EscolaBusiness escolaBusiness = new EscolaBusiness();
		Escola escola = new Escola();
		CursoBusiness cursoBusiness = new CursoBusiness();
		Curso curso = new Curso();

		Aluno aluno = new Aluno();
		AlunoBusiness alunoBusiness = new AlunoBusiness();
		NotaBusiness notaBusiness = new NotaBusiness();
		Nota nota = new Nota();

		int opcao1 = Integer.parseInt(JOptionPane.showInputDialog("O que deseja fazer? \n 1 - Incluir registro"
				+ "\n 2 - Realizar consulta por ID \n 3 - Listar registros"));

		if (opcao1 == 1) {
			int opcao2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Incluir nova escola \n 2- Incluir novo curso"
					+ "\n 3 - Incluir novo aluno" + "\n 4 - Incluir todos"));

			if (opcao2 == 1) {
				escola.setNome(JOptionPane.showInputDialog("Nome da Escola"));
				escola.setDataString(JOptionPane.showInputDialog("Data de Fundação"));
				escola.setEndereco(JOptionPane.showInputDialog("Endereço da Escola"));
				escolaBusiness.incluirEscola(escola);
			} else if (opcao2 == 2) {
				curso.setNome(JOptionPane.showInputDialog("Nome do Curso"));
				escola.setNome(JOptionPane.showInputDialog("Nome da Escola"));
				curso.setEscola(escola);
				cursoBusiness.incluirCurso(curso);
			} else if (opcao2 == 3) {
				aluno.setNome(JOptionPane.showInputDialog("Nome do Aluno"));
				aluno.setDocumento(JOptionPane.showInputDialog("Documento"));
				aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
				aluno.setTelefone(JOptionPane.showInputDialog("Telefone"));
				alunoBusiness.incluirAluno(aluno);
			} else if (opcao2 == 4) {

				aluno.setNome(JOptionPane.showInputDialog("Nome do Aluno"));
				aluno.setDocumento(JOptionPane.showInputDialog("Documento"));
				aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
				aluno.setTelefone(JOptionPane.showInputDialog("Telefone"));
				escola.setNome(JOptionPane.showInputDialog("Nome da Escola"));
				escola.setDataString(JOptionPane.showInputDialog("Data de Fundação"));
				escola.setEndereco(JOptionPane.showInputDialog("Endereço da Escola"));
				curso.setNome(JOptionPane.showInputDialog("Nome do Curso"));
				curso.setEscola(escola);
				nota.setNota(Double.parseDouble(JOptionPane.showInputDialog("Nota")));
				nota.setAluno(aluno);
				nota.setCurso(curso);
				curso.getNotas().add(nota);
				aluno.getNotas().add(nota);
				escola.getCursos().add(curso);
				alunoBusiness.incluirAluno(aluno);
			} else {
				JOptionPane.showMessageDialog(null, "Opção Inválida!");
			}
		} else if (opcao1 == 2) {
			int opcao3 = Integer.parseInt(JOptionPane
					.showInputDialog("1 - Consultar Escola" + "\n 2 - Consultar Curso \n 3 - Consultar Aluno"));
			int id = 0;
			if (opcao3 == 1) {
				id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da Escola"));
				try {
					JOptionPane.showMessageDialog(null, escolaBusiness.buscarEscolaPorId(id));
				} catch (Exception e) {

				}
			} else if (opcao3 == 2) {
				id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Curso"));
				try {
					JOptionPane.showMessageDialog(null, cursoBusiness.buscarCursoPorId(id));
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Curso não encontrado!");
				}
			} else if (opcao3 == 3) {
				id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Aluno"));
				try {
					JOptionPane.showMessageDialog(null, alunoBusiness.buscarAlunoPorId(id));

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Opção Inválida!");
			}
		} else if (opcao1 == 3) {
			int opcao4 = Integer.parseInt(JOptionPane.showInputDialog("1 - Escolas" + "\n 2 - Cursos \n 3 - Alunos"));
			if (opcao4 == 1) {
				String listaEscolas = "";
				try {
					for (Escola escola1 : escolaBusiness.listarTodasEscolas()) {
						listaEscolas = listaEscolas + escola1 + "\n";
					}
					JOptionPane.showMessageDialog(null, listaEscolas);
				} catch (Exception e) {
					JOptionPane.showInputDialog("Erro ao listar Escolas");
				}
			} else if (opcao4 == 2) {
				String listaCursos = "";
				try {
					for (Curso curso1 : cursoBusiness.listarCursos()) {
						listaCursos = listaCursos + curso1 + "\n";
					}
					JOptionPane.showMessageDialog(null, listaCursos);
				} catch (Exception e) {
					JOptionPane.showInputDialog("Erro ao listar Cursos");
				}
			}
			if (opcao4 == 3) {
				String listaAlunos = "";
				try {
					for (Aluno aluno1 : alunoBusiness.listarAlunos()) {
						listaAlunos = listaAlunos + aluno1 + "\n";
					}
					JOptionPane.showMessageDialog(null, listaAlunos);
				} catch (Exception e) {
					JOptionPane.showInputDialog("Erro ao listar Alunos");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Opção Inválida!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
		}
	}

}
