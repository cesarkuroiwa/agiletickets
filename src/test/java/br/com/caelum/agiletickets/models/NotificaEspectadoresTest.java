package br.com.caelum.agiletickets.models;

import java.util.Arrays;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class NotificaEspectadoresTest {
	
	@Test
	public void testaNotificaEspectador() {
		Espectador e = new Espectador();
		Enviador enviador = mock(Enviador.class);
		NotificaEspectadores ne = new NotificaEspectadores(enviador);
		ne.notifica(Arrays.asList(e));
		verify(enviador).envia(e);
	}
}
