package agenda.model.enuns;

public enum Dia {

	SEGUNDA("Segunda-feira"), TERCA("Terça-feira"), QUARTA("Quarta-feira"), QUINTA("Quinta-feira"), SEXTA(
			"Sexta-feira"), SABADO("Sabado"), DOMINGO("Domingo");

	private String descricao;

	private Dia(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
