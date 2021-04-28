package server.dao.daoInterfaces;

import java.util.List;

import server.entity.Maquina;

public interface MaquinaInterface {
	
	void comprarMaquina();
	List<Maquina> getMaquinas();
	
}
