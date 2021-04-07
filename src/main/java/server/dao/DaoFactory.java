package server.dao;

import server.connect.Db;
import server.dao.daoImplementation.FuncionarioImp;
import server.dao.daoInterfaces.FuncionarioInterface;

public class DaoFactory {

	public static FuncionarioInterface createFuncionarioDao() {
		return new FuncionarioImp(Db.getConnection());
	}
}
