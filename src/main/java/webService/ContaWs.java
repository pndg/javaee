package webService;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import br.com.javaee.beans.ContaBean;
import br.com.javaee.dao.ContaDao;
import br.com.javaee.models.Conta;

@Stateless
@WebService
public class ContaWs {
	
	@Inject
	ContaDao dao;
	//private Conta conta = new Conta();
	
	@Inject
	ContaBean bean;
	
	
	
	public List<Conta> listaWs(String nome){
		System.out.println("LivrariaWS: procurando pelo nome " + nome);
        return dao.listWs(nome);
		
	}
	
	public List<Conta> listar(){
		
		return dao.listar();
		
	}
	
	Conta conta = new Conta();
	
	
	
	public void salvar(Conta conta) {
		
		String nome = conta.getNome();
		String data = conta.getDataLancamento();
		Double valor = conta.getValor();
		Integer tipo = conta.getTipoLancamento();
		
		conta.setNome(nome);
		conta.setDataLancamento(data);
		conta.setValor(valor);
		conta.setTipoLancamento(tipo);
		dao.salvar(conta);
		
		
		
	}
	
	
	public void excluir(Conta conta) throws Exception {
		
		bean.excluir(conta);
		
		
	}
	

}
