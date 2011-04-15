package br.com.caelum.agiletickets.models;

import java.util.List;

public class NotificaEspectadores {
	private Enviador enviador;
	
	public NotificaEspectadores(Enviador enviador) {
		// TODO Auto-generated constructor stub
		this.enviador = enviador;
	}

	public void notifica(List<Espectador> espectadores) {
		for (Espectador e : espectadores) {
			enviador.envia(e);
		}
	}

}
