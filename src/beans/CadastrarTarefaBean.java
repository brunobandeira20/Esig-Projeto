package beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import domains.Tarefa;

@ManagedBean
@RequestScoped
public class CadastrarTarefaBean {
	private Tarefa tarefa ;
	

	public CadastrarTarefaBean() {
		tarefa = new Tarefa();
	}

	public Tarefa gettarefa() {
		return tarefa;
	}

	public void settarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	
}
