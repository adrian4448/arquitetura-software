package server.dao;

import server.dao.daoImplementation.FuncionarioImp;
import server.dao.daoImplementation.InvestimentoImp;
import server.dao.daoImplementation.MaquinaImp;
import server.dao.daoInterfaces.FuncionarioInterface;
import server.dao.daoInterfaces.InvestimentoInterface;
import server.dao.daoInterfaces.MaquinaInterface;
import server.dao.daoImplementation.CustosImp;
import server.dao.daoInterfaces.CustoInterface;

public class DaoFactory {

	public static FuncionarioInterface createFuncionarioDao() {
		return new FuncionarioImp();
	}
	
	public static CustoInterface createCustoDao() {
		return new CustosImp();
	}
	
	public static InvestimentoInterface createInvestimentoDao() {
		return new InvestimentoImp();
	}
	
	public static MaquinaInterface createMaquinaDao() {
		return new MaquinaImp();
	}
}
