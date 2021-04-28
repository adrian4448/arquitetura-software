package server.dao.daoInterfaces;

import java.util.List;

import server.entity.Custo;

public interface CustoInterface {
	
	List<Custo> getAllCustos();
	Custo getCusto(Integer id);
	void addCusto(Custo custo);
	void alterarCusto(Custo custo);
	void vincularCusto(Custo custo);
	void excluirCusto(Integer id);
	
}
