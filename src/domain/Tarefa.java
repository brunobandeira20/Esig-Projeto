package domain;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue  (strategy=GenerationType.IDENTITY)  
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(nullable = false)
	private Date deadLine;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String responsavel;	
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String prioridade;
	
	@Column(nullable = false)
	private boolean completa=false ;
	
	public boolean isCompleta() {
		return completa;
	}
	public void setCompleta(boolean completa) {
		this.completa = completa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDeadline() {
		return deadLine;
	}
	public void setDeadline(Date deadline) {
		this.deadLine = deadline;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
