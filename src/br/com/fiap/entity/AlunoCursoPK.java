package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
public class AlunoCursoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3023396586632676824L;

	@Column(name = "aluno_id")
	private int idAluno;
	
	@Column(name = "curso_id")
	private int idCurso;
	
	@Column(name = "curso_escola_id")
	private int idCursoEscola;
	
	
	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdCursoEscola() {
		return idCursoEscola;
	}

	public void setIdCursoEscola(int idCursoEscola) {
		this.idCursoEscola = idCursoEscola;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof AlunoCursoPK) {
			AlunoCursoPK pk = (AlunoCursoPK)o;
			
			if(this.getIdAluno() != pk.getIdAluno()) {
				return false;
			}
			
			if(this.getIdCurso() != pk.getIdCurso()){
				return false;
			}
			
			if(this.getIdCursoEscola() != pk.getIdCursoEscola()){
				return false;
			}
			
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.getIdAluno() + this.getIdCurso() + this.getIdCursoEscola();
	}
}
