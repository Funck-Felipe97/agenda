package agenda.model.enuns;

public enum Permissao {

	ROLE_CLIENTE("Cliente"),
	ROLE_FUNCIONARIO("Funcionario"),
	ROLE_ADMINISTRADOR("Administrador");
	
	private String descricao;
	
	private Permissao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
