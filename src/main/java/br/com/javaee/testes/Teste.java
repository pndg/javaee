package br.com.javaee.testes;

import javax.inject.Inject;

import org.junit.Test;

import br.com.javaee.beans.ContaBean;
import br.com.javaee.models.Conta;

@SuppressWarnings({ "Deprecation", "deprecation" })
public class Teste {
	
	@Inject
	private ContaBean bean;
	
	private Conta conta;
	
		
	
	
	
	@Test
	public void testesalvar() {
		conta = new Conta();
        conta.setNome("TESTE");
        conta.setDataLancamento("13/08/2018");
        conta.setValor(47.80);
        conta.setTipoLancamento(1);
		
		conta = bean.salvar(conta);
		
		
		
	}
	

}
