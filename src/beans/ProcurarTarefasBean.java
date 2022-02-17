package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import dao.Database;
import dao.TarefaDao;
import domains.Tarefa;
import resources.MetodosResource;

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

	public String encontrar() {
		dao = new TarefaDao();

		tarefasEncontradas = dao.buscarTarefa(limiteBusca, tituloBusca, responsavelBusca, situacaoBusca);

		return ""; // waiting
	}

	public TarefaDao getDao() {
		return dao;
	}

	public void setDao(TarefaDao dao) {
		this.dao = dao;
	}

	public String alterarSituacao(Tarefa t) {
		EntityManager em = Database.getInstance().getEntityManager();

		try {

			em.getTransaction().begin();
			t.setCompleta(!t.isCompleta());
			em.merge(t);
			MetodosResource.addMensagem("Tarefa alterada com sucesso!!");
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (em.getTransaction().isActive())

				em.getTransaction().rollback();
		}
		return encontrar();
	}

	public String removerTarefa(Tarefa t) {
		EntityManager em = Database.getInstance().getEntityManager();

		try {

			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			MetodosResource.addMensagem("Tarefa deletada com sucesso!!");
		} catch (Exception e) {
			e.printStackTrace();

			if (em.getTransaction().isActive())

				em.getTransaction().rollback();
		}

		return encontrar();
	}
}
