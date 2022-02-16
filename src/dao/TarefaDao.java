package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import domain.Tarefa;

public class TarefaDao extends GenricDao {

	private static final long serialVersionUID = 1L;

	public List<Tarefa> buscarTarefa(Integer limiteBusca, String tituloBusca, String responsavelBusca,
			boolean situacaoBusca) {
		EntityManager em = getEntityManager();

		String hql = "SELECT tr FROM Tarefa tr ";
		hql += "WHERE 1=1";

		if (!responsavelBusca.isEmpty() && responsavelBusca != null) {
			hql += " AND tr.responsavel like:responsavelBusca";
		}
		if (!tituloBusca.isEmpty() && tituloBusca != null) {
			hql += " AND tr.titulo like:tituloBusca";
		}

		hql += " AND tr.completa=:situacaoBusca";
		hql += " ORDER BY tr.deadline DESC ";

		Query q = em.createQuery(hql);

		if (limiteBusca != null && limiteBusca != 0) {
			q.setMaxResults(limiteBusca);
		}
		if (!responsavelBusca.isEmpty() && responsavelBusca != null) {
			q.setParameter("responsavelBusca", responsavelBusca);
		}
		if (!tituloBusca.isEmpty() && tituloBusca != null) {
			q.setParameter("tituloBusca", tituloBusca);
			
		}

		q.setParameter("situacaoBusca", situacaoBusca);
		try {
			@SuppressWarnings("unchecked")
			List<Tarefa> result = q.getResultList();

			return result;
		} catch (NoResultException e) {
			return null;
		}
	}
}
