package br.com.fiap.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1430839478754909656L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOME", length=45)
	private String nome;
	
	@Column(name="TELEFONE", length=10)
	private String telefone;
	
	@Column(name="DOCUMENTO", length=15)
	private String documento;
	
	@Column(name="IDADE")
	private int idade;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="aluno")
	private Set<Nota> notas = new LinkedHashSet<Nota>();

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Set<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Set<Nota> notas) {
		this.notas = notas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome.toUpperCase();
	}
	
}
