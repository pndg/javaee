package br.com.javaee.beans;

import static org.junit.jupiter.api.Assertions.fail;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import br.com.javaee.models.Conta;

class ContaBeanTest {

	@Inject
	private ContaBean bean;
	
	private Conta conta;
	@Test
	void testSalvar() {
		conta = new Conta();
        conta.setNome("TESTE");
        conta.setDataLancamento("13/08/2018");
        conta.setValor(47.80);
        conta.setTipoLancamento(1);
		
		conta = bean.salvar(conta);
		bean.excluir(conta);
	}

	@Test
	void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	void testListar() {
		fail("Not yet implemented");
	}

	@Test
	void testListarId() {
		fail("Not yet implemented");
	}

	@Test
	void testListaNome() {
		fail("Not yet implemented");
	}

	@Test
	void testListTipoLancamento() {
		fail("Not yet implemented");
	}

	@Test
	void testListaData() {
		fail("Not yet implemented");
	}

}
