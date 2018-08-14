package br.com.javaee.testes;

import javax.inject.Inject;

import org.junit.Test;

import br.com.javaee.beans.ContaBean;
import br.com.javaee.models.Conta;
import junit.framework.Assert;

@SuppressWarnings({ "Deprecation", "deprecation" })
public class Teste {
	
	@Inject
	private ContaBean bean;
	
	private Conta conta;
	
	public Teste() {
		
		conta = new Conta();
        conta.setNome("TESTE");
        conta.setDataLancamento("13/08/2018");
        conta.setValor(47.80);
        conta.setTipoLancamento(1);
		conta.setId(25);
		
	}
	
	@Test
	public void testesalvar() {
		
		conta = bean.salvar(conta);
		Assert.assertTrue(conta.getId() > 0);
		
	}
	

}
