package br.com.javaee.teste;



import javax.inject.Inject;


import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.common.Assert;

import br.com.javaee.beans.ContaBean;
//import br.com.javaee.dao.ContaDao;
import br.com.javaee.models.Conta;

@RunWith(Arquillian.class)
public class Teste {
	
	@Inject
	public ContaBean bean;
	
	public Conta conta = new Conta();
	
	

	public Teste() {
	   
	  
	  conta.setNome("Teste Junit");
	  conta.setTipoLancamento(1);
	  conta.setValor(12.50);
	  conta.setDataLancamento("14/08/2018");
	  conta.setId(99);
	  	  
	    
	}
	
	
	 @Test
	    @InSequence(1)
	    public void testeSalvar() {

	        try {
	        		conta = bean.salvar(conta);
	        		bean.excluir(conta);
	        		Assert.assertTrue(conta.getId() > 0);

	        } catch (Exception ex) {
	           
	        }

	    }
	 	@Test
	    @InSequence(2)
	    public void testeExcluir() throws Exception {
	 	try {
	        conta = bean.salvar(conta);
	        bean.excluir(conta);
	        Assert.assertTrue(conta.getId() > 0);
	 	 } catch (Exception ex) {
	           
	        }

	    }
	 	
	 	
	    @Test
	    @InSequence(3)
	    public void testeAtualizar() throws Exception {
	    	
	    	String nome = "Alterada" ;
	        conta = bean.salvar(conta);
	        conta.setNome(nome);
	        bean.alterar(conta);
	        Conta busca = bean.listarId(conta.getId());

	        bean.excluir(conta);
	        Assert.assertTrue(busca.getNome().equals(nome));

	    }

	   
	   
}
