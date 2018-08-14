package br.com.javaee.beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import br.com.javaee.dao.ContaDao;
import br.com.javaee.models.Conta;

@Stateless
public class ContaBean {
	
	
	
	@Inject
	private ContaDao dao;
	
	@Transactional
	public Conta salvar(Conta conta) {
		
		try {	
				conta = dao.salvar(conta);
			
			
			} catch (Exception e) {
				System.out.println(e);
			}
		
			return conta;
	}
	
	@Transactional
	public void excluir(Conta conta) {
		
		dao.excluir(conta);
		
	}
	
	@Transactional
	public Conta alterar(Conta conta) {
		try {	
				conta = dao.alterar(conta);
			} catch (Exception e) {
				System.out.println(e);
			}
		
			return conta;
		
		}
	
		
	private List<Conta> contas = new ArrayList<>();	
	
	@Transactional
	public List<Conta> listar() {
		
			
		this.contas = dao.listar();
		return contas;
		
	}
	
	public Conta listarId(Integer id){
		
		return dao.listarId(id);
		
	}
	
	private List<Conta> contasNome = new ArrayList<>();	
	@Transactional
	public List<Conta> listaNome(Conta conta){
		
		for(Conta contaN : dao.listarNome(conta)) {
			
			contasNome.add(contaN);
		}
			
		return contasNome;
	}	
		
	

	@Transactional
	public List<Conta> listTipoLancamento(Conta conta){
		
		return dao.listarTipoLancamento(conta);
		
	}
	
	
	public List<Conta> contasData = new ArrayList<>();
	@Transactional
	public List<Conta> listaData(Conta conta){
		
		for(Conta contaD : dao.listarData(conta)) {
			
			contasData.add(contaD);
		}
		
		return contasData;
	}
	
}
