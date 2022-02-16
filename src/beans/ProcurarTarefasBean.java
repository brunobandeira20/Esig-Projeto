package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.TarefaDao;
import domain.Tarefa;

@ManagedBean
@SessionScoped
public class ProcurarTarefasBean {

	private TarefaDao dao;

	private String responsavelBusca;
	private boolean situacaoBusca;
	private Integer limiteBusca;
	private String tituloBusca;

	private List<Tarefa> tarefasEncontradas;

	public String getResponsavelBusca() {
		return responsavelBusca;
	}

	public void setResponsavelBusca(String responsavelBusca) {
		this.responsavelBusca = responsavelBusca;
	}

	public Integer getLimiteBusca() {
		return limiteBusca;
	}

	public void setLimiteBusca(Integer limiteBusca) {
		this.limiteBusca = limiteBusca;
	}

	public String getTituloBusca() {
		return tituloBusca;
	}

	public void setTituloBusca(String tituloBusca) {
		this.tituloBusca = tituloBusca;
	}

	public void setSituacaoBusca(boolean situacaoBusca) {
		this.situacaoBusca = situacaoBusca;
	}

	public List<Tarefa> getTarefasEncontradas() {
		return tarefasEncontradas;
	}

	public void setTarefasEncontradas(List<Tarefa> tarefasEncontradas) {
		this.tarefasEncontradas = tarefasEncontradas;
	}

	public boolean isSituacaoBusca() {
		return situacaoBusca;
	}

}
