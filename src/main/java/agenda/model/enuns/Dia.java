package agenda.model.enuns;

public enum Dia {

	SEGUNDA("Segunda-feira"), TERCA("Terca-feira"), QUARTA("Quarta-feira"), QUINTA("Quinta-feira"), SEXTA(
			"Sexta-feira"), SABADO("Sabado"), DOMINGO("Domingo");

	private final String descricao;

	private Dia(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Dia getEnum(String dia) {
		switch (dia) {
			case "Segunda-feira":
				return SEGUNDA;
			case "Terça-feira":
				return TERCA;
			case "Quarta-feira":
				return QUARTA;
			case "Quinta-feira":
				return QUINTA;
			case "Sexta-feira":
				return SEXTA;
			case "Sabado":
				return SABADO;
			case "Domingo":
				return DOMINGO;
			default:
				return null;
		}
	}
	
}
