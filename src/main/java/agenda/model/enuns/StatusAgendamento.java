package agenda.model.enuns;

public enum StatusAgendamento {

	AGENDADO("Agendado"),
	ATENDIDO("Atendido"),
	CANCELADO("Cancelado");
	
	private String descricao;
	
	private StatusAgendamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
