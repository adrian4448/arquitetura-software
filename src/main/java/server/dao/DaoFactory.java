package server.dao;

import server.dao.daoImplementation.FuncionarioImp;
import server.dao.daoInterfaces.FuncionarioInterface;

public class DaoFactory {

	public static FuncionarioInterface createFuncionarioDao() {
		return new FuncionarioImp();
	}
}
