package server.dao.daoInterfaces;

import java.util.List;

import server.entity.Investimento;

public interface InvestimentoInterface {
	
	void adicionarInvestimento(Investimento investimento);
	void excluirInvestimento(Integer id);
	void alterarInvestimento(Investimento investimento);
	Investimento getInvestimentoById(Integer id);
	List<Investimento> getAllInvestimentos();
	
}
