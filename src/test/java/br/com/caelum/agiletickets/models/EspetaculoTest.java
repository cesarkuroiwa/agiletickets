package br.com.caelum.agiletickets.models;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {
	@Test
	public void cria1Sessao() {
		Espetaculo espetaculo = new Espetaculo();
		
		LocalDate data = new LocalDate();
		LocalTime hora = new LocalTime();
		List<Sessao> sessoes = espetaculo.criaSessoes(data, data, hora, Periodicidade.DIARIA);
		Assert.assertEquals(sessoes.size(), 1);
	}
	
	@Test
	public void cria1SessaoEm1Dia() {
		Espetaculo espetaculo = new Espetaculo();
		
		LocalDate data = new LocalDate();
		LocalTime hora = new LocalTime();
		List<Sessao> sessoes = espetaculo.criaSessoes(data, data, hora, Periodicidade.DIARIA);
		Assert.assertEquals(sessoes.size(), 1);
		Sessao sessao = sessoes.get(0);
		Assert.assertEquals(sessao.getInicio(), data.toDateTime(hora));
	}
	
	@Test
	public void cria7SessoesDiarias() {
		Espetaculo espetaculo = new Espetaculo();
		
		LocalDate inicio = new LocalDate();
		LocalDate fim = inicio.plusDays(6);
		LocalTime hora = new LocalTime();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, hora, Periodicidade.DIARIA);
		Assert.assertEquals(sessoes.size(), 7);
		int dia = 0;
		for (Sessao sessao : sessoes) {
			DateTime dateTime = inicio.plusDays(dia).toDateTime(hora);
			Assert.assertEquals(sessao.getInicio(), dateTime);
			dia++;
		}
	}
	
	@Test
	public void cria1SessaoSemanal() {
		Espetaculo espetaculo = new Espetaculo();
		
		LocalDate inicio = new LocalDate();
		LocalDate fim = inicio.plusDays(6);
		LocalTime hora = new LocalTime();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, hora, Periodicidade.SEMANAL);
		Assert.assertEquals(1, sessoes.size());	
	}
	
	@Test
	public void cria2SessoesSemanais() {
		Espetaculo espetaculo = new Espetaculo();
		
		LocalDate inicio = new LocalDate();
		LocalDate fim = inicio.plusDays(14);
		LocalTime hora = new LocalTime();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, hora, Periodicidade.SEMANAL);
		Assert.assertEquals(2, sessoes.size());
		int dia = 0;
		for (Sessao sessao : sessoes) {
			DateTime dateTime = inicio.plusDays(dia).toDateTime(hora);
			Assert.assertEquals(sessao.getInicio(), dateTime);
			Assert.assertEquals(hora.getMillisOfDay(), sessao.getInicio().getMillisOfDay());
			dia += 7;
		
		}
	}
}
