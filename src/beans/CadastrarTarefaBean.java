package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import dao.Database;
import domains.Tarefa;
import resources.MetodosResource;


@ManagedBean
@RequestScoped
public class CadastrarTarefaBean {
	private Tarefa tarefa;

	public CadastrarTarefaBean() {
		tarefa = new Tarefa();
	}

	public Tarefa gettarefa() {
		return tarefa;
	}

	public void settarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public String editarTarefa(Tarefa tarefa) {
		this.tarefa = tarefa; 
		return "/index.xhtml";
	}
	public String cadastrar() {
		EntityManager gerenciador = Database.getInstance().getEntityManager();
		gerenciador.getTransaction().begin();
		boolean erro = false;

		if (MetodosResource.estaVazio(tarefa.getTitulo())) {
			MetodosResource.addMensagem("Campo Título obrigatório!");
			erro = true;
		}
		if (MetodosResource.estaVazio(tarefa.getDescricao())) {
			MetodosResource.addMensagem("Campo Descrição obrigatório!");
			erro = true;
		}
		if (MetodosResource.estaVazio(tarefa.getPrioridade())) {
			MetodosResource.addMensagem("Campo Prioridade obrigatório!");
			erro = true;
		}
		if (MetodosResource.estaVazio(tarefa.getResponsavel())) {
			MetodosResource.addMensagem("Campo Responsável obrigatório!");
			erro = true;
		}
		if (tarefa.getDeadline() == null) {
			MetodosResource.addMensagem("Campo Deadline obrigatório!");
			erro = true;
		}
		if (erro) {
			if (gerenciador.getTransaction().isActive()) {
				gerenciador.getTransaction().rollback();
			}
			return null;
		} else {
			try {
				if (tarefa.getId() == 0)
					gerenciador.persist(tarefa);
				else
					gerenciador.merge(tarefa);

				gerenciador.getTransaction().commit();
				MetodosResource.addMensagem("Seu cadastro está pronto!");

			} catch (Exception e) {
				e.printStackTrace();

				if (gerenciador.getTransaction().isActive()) {
					gerenciador.getTransaction().rollback();
				}
			}

			tarefa = new Tarefa();
			return null;
		}

	}
	

}
