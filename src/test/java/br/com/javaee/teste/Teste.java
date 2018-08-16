package br.com.javaee.teste;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.common.Assert;

import br.com.javaee.beans.ContaBean;
import br.com.javaee.models.Conta;

@RunWith(Arquillian.class)
public class Teste {
	
	@Inject
	private ContaBean bean;
	
	private Conta conta;
	
    /*@Deployment
    public static JavaArchive arquivoTeste() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(ContaBean.class,
                        
                        Conta.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/
	

	public Teste() {
	   
		
	
	  conta = new Conta();
	  /*conta.setId(99);*/
	  conta.setNome("Teste Junit");
	  conta.setTipoLancamento(1);
	  conta.setValor(12.50);
	  conta.setDataLancamento("14/08/2018");
	  
	  	  
	    
	}
	
	
	 @Test
	    @InSequence(1)
	    public  void testeSalvar() throws Exception {
		 try {
			 conta = bean.salvar(conta);
			 Assert.assertTrue(conta.getId() > 0);
			 bean.excluir(conta);
		 } catch (Exception e) {
				
			}

	    }
	 
	 
	 	@Test
	    @InSequence(2)
	    public void testeExcluir() throws Exception {
	 	try {
	        conta = bean.salvar(conta);
	        Assert.assertTrue(conta.getId() > 0);
	        bean.excluir(conta);
	 	 } catch (Exception ex) {
	           
	        }

	    }
	 	
	 	
	    @Test
	    @InSequence(3)
	    public void testeAtualizar() throws Exception {
	    try {	
	    	String nome = "Alterada" ;
	        conta = bean.salvar(conta);
	        conta.setNome(nome);
	        bean.alterar(conta);
	        Conta busca = bean.listarId(conta.getId());

	        bean.excluir(conta);
	        Assert.assertTrue(busca.getNome().equals(nome));
	    } catch (Exception e) {
			
		}


	    }
	    
	    
	    @Test
	    @InSequence(4)
	    public void testeListacontas() throws Exception {
	   try {
	        List<Conta> contas = new ArrayList<>();
	        conta = bean.salvar(conta);
	        contas = bean.listar();

	        bean.excluir(conta);
	        Assert.assertTrue(contas.size()>0);
	        
	    } catch (Exception e) {
			
		}


	    }

	    @Test
	    @InSequence(5)
	    public void testeListaNome() throws Exception {
	    try {
	        List<Conta> contas = new ArrayList<>();
	        conta = bean.salvar(conta);
	        contas = bean.listaNome(conta);

	        boolean validar = false;
	        for (Conta c : contas) {
	        		
	            	if (c.getId().equals(conta.getId())) {
	                validar = true;
	            }
	            	
	        }

	        bean.excluir(conta);
	        
	        Assert.assertTrue(validar);
	    } catch (Exception e) {
			
		}


	    }

	    @Test
	    @InSequence(6)
	    public void testeLisarId() throws Exception {
	    try {
	        conta = bean.salvar(conta);
	        Conta retorno = bean.listarId(conta.getId());

	        bean.excluir(conta);
	        Assert.assertTrue(retorno.getNome().equals(conta.getNome()));
	    	} catch (Exception e) {
	    			
	    	}

	    }

	    @Test
	    @InSequence(7)
	    public void testaConsultaDeContaPorTipoLancamento() throws Exception {
	    try {
	        List<Conta> contas = new ArrayList<>();
	        conta = bean.salvar(conta);
	        contas = bean.listTipoLancamento(conta);
	        boolean validar = false;

	        for (Conta c : contas) {
	            if (c.getId().equals(conta.getId())) {
	                validar = true;
	            }
	        }

	        bean.excluir(conta);
	        Assert.assertTrue(validar);
	        
	    	} catch (Exception e) {
	    		
	    	}


	    }

	    @Test
	    @InSequence(8)
	    public void testeListaDataLancamento() throws Exception {
	     try {
	        List<Conta> contas = new ArrayList<>();
	        conta = bean.salvar(conta);
	       // String dataLancamento = "15/08/2018";
	        contas = bean.listaData(conta);

	        boolean valida = false;
	        for (Conta c : contas) {
	            if (c.getId().equals(conta.getId())) {
	                valida = true;
	            }
	        }

	        bean.excluir(conta);
	        Assert.assertTrue(valida);
	    	} catch (Exception e) {
	    	}


	    }

	   
	   
}
