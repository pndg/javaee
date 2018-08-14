package br.com.javaee.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.javaee.models.Conta;

@Stateless
public class ContaDao {
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager manager;
	
	public Conta salvar(Conta conta) {
		
		manager.persist(conta);
		return conta;
		
	}
	
	public void excluir(Conta conta) {
		
		Conta contaE = manager.find(Conta.class,conta.getId());
		 manager.remove(contaE);
		
	}
	
	public Conta alterar(Conta conta) {
		
	return manager.find(Conta.class,conta.getId());
				
		
	}
	
	public List<Conta> listar() {
		
		String jpql = "select c from conta c";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
	
	public Conta listarId(Integer id) {
		
		return manager.find(Conta.class, id);
		
	}
	
	public List<Conta> listarData(Conta conta) {
		
		String jpql = "select c from conta c where dataLancamento = " + conta.getDataLancamento()+"";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
	
	public List<Conta> listarNome(Conta conta){
		
		String jpql = "select c from conta c where c.nome like '%" + conta.getNome()+ "%'";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
		
	public List<Conta> listarTipoLancamento(Conta conta){
		
		String jpql = "select c from conta c where c.nome tipolancamento = " + conta.getTipoLancamento() + "";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
		
}
	
	
	
	
	
	
	

	
