package server.dao.daoInterfaces;

import java.util.HashMap;
import java.util.List;

import server.entity.Funcionario;

public interface FuncionarioInterface {
	
	void cadastrarFuncionario(Funcionario funcionario);
	void calcularSalario(Funcionario funcionario);
	List<Funcionario> getFuncionarios();
	List<Funcionario> gastosPeriodo(HashMap<String, Object> params);
	
}
