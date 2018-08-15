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
	public  void testeSalvar() throws Exception{
				
			try {
				
				conta = bean.salvar(conta);
				
				Assert.assertTrue(conta.getId()>0);
				
				
			} catch (Exception e) {
				//throw (e);
			}
			
			
       		
	}
	
	@Test
	@InSequence(2)
	public void testeExcluir() throws Exception{
		
	try {
		conta = bean.salvar(conta);
		System.out.println(conta);
		
	} catch (Exception e) {
		 System.err.println("An IOException was caught :"+e.getMessage());

	}
		
	}

}
