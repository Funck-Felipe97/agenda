package agenda.dao;

import agenda.model.Servico;

public class ServicoDao extends AbstractDao<Servico>{

	public ServicoDao() {
		super(Servico.class);
	}

	public Servico findByDescricao(String descricao) {
		return (Servico) createNamedQuery("servico.findByDescricao")
				.setParameter("descricao", descricao)
				.getSingleResult();
	}

}
