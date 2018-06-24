package br.com.fiap.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "escola")
public class Escola implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1551971431422694057L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOME", length=45)
	private String nome;
	
	@Column(name="ENDERECO", length=45)
	private String endereco;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DATA_FUNDACAO")
	private Date dataFundacao;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="escola")
	private Set<Curso> cursos = new LinkedHashSet<Curso>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	//propriedade de conveniencia
	public void setDataString(String data) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.setDataFundacao(df.parse(data));
		} catch (Exception e) {
			this.setDataFundacao(new Date());
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNome().toUpperCase();
	}

}
