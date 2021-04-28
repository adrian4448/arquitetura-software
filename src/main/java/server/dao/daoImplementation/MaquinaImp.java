package server.dao.daoImplementation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import server.connect.Db;
import server.dao.daoInterfaces.MaquinaInterface;
import server.entity.Maquina;

public class MaquinaImp implements MaquinaInterface{

	@Override
	public void comprarMaquina() {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("INSERT INTO maquina (DESCRICAO_MAQUINA, FATURAMENTO_MAQUINA)");
			sql.append("VALUES ('Maquina Pesada', '7500')");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}

	@Override
	public List<Maquina> getMaquinas() {
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		List<Maquina> maquinas = new ArrayList<>();
		try {
			sql.append("SELECT * FROM maquina");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				maquinas.add(montarMaquina(rs));
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return maquinas;
	}
	
	private Maquina montarMaquina(ResultSet rs) throws Exception{
		Maquina maquina = new Maquina();
		maquina.setId(rs.getInt("ID"));
		maquina.setDescMaquina(rs.getString("DESCRICAO_MAQUINA"));
		maquina.setRenda(rs.getDouble("FATURAMENTO_MAQUINA"));
		return maquina;
	}
	
}
