package com.bmlinformtica.course.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1, "Aguardando Pagamento"), PAID(2, "Pago"), SHIPPED(3, "Enviado"), DELIVERED(4, "Entregue"),
	CANCELED(5, "Cancelado");

	private int cod;
	private String descricao;

	private OrderStatus(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static OrderStatus toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (OrderStatus x : OrderStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}
