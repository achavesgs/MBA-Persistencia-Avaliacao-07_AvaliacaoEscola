package br.com.fiap.business;

import java.util.List;

import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import br.com.fiap.entity.Escola;
import br.com.fiap.jdbc.JdbcEscolaDao;

public class EscolaBusiness {
	
	public void incluirEscola(Escola escola) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			
			JdbcEscolaDao dao = (JdbcEscolaDao)context.getBean("jdbcEscolaDao");

			dao.incluirEscola(escola);
			
			JOptionPane.showMessageDialog(null, "Escola incluída com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "Erro ao incluir escola: "+e.getMessage());
		}
	}
	
	public Escola buscarEscolaPorNome(String nomeEscola) throws Exception{
		Escola escola = new Escola();
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			
			JdbcEscolaDao dao = (JdbcEscolaDao)context.getBean("jdbcEscolaDao");
			
			escola = dao.buscarEscolaPorNome(nomeEscola);
			
			System.out.println("Escola: "+escola.toString());
			return escola;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
//			JOptionPane.showMessageDialog(null, "Erro ao buscar escola: "+e.getMessage());
		}

	}
	
	public Escola buscarEscolaPorId(int idEscola) throws Exception{
		Escola escola = new Escola();
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
			
			JdbcEscolaDao dao = (JdbcEscolaDao)context.getBean("jdbcEscolaDao");
			
			escola = dao.buscarEscolaPorId(idEscola);
			
			System.out.println("Escola: "+escola.toString());
			return escola;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
//			JOptionPane.showMessageDialog(null, "Erro ao buscar escola: "+e.getMessage());
		}

	}
	
	public List<Escola> listarTodasEscolas() throws Exception {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beanJdbc.xml");
						
			List<Escola> escolas = ((JdbcEscolaDao)context.getBean("jdbcEscolaDao")).listarEscolas();
			
			return escolas;		
						
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
//			JOptionPane.showMessageDialog(null, "Erro ao buscar todas as escolas: "+e.getMessage());
		}

	}

}
