package br.com.javaee.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import br.com.javaee.models.Conta;

@Stateless
public class ContaDao {
	
	@PersistenceContext//(type=PersistenceContextType.EXTENDED)
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
		
		String jpql = "select c from Conta c";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Conta> listWs(String nome){
		
		String sql = "select c from Conta c where upper(c.nome) like '%" + nome.toUpperCase() + "%'";
				Query query = manager.createQuery(sql);
		        return query.getResultList();
		
	}
	
	public Conta listarId(Integer id) {
		
		return manager.find(Conta.class, id);
		
	}
	
	public List<Conta> listarData(Conta conta) {
		
		String jpql = "select c from Conta c where dataLancamento = " + conta.getDataLancamento()+"";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
	
	public List<Conta> listarNome(Conta conta){
		
		String jpql = "select c from Conta c where c.nome like '%" + conta.getNome()+ "%'";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
		
	public List<Conta> listarTipoLancamento(Conta conta){
		
		String jpql = "select c from Conta c where c.nome tipolancamento = " + conta.getTipoLancamento() + "";
		return manager.createQuery(jpql,Conta.class).getResultList();
		
	}
		
}
	
	
	
	
	
	
	

	
