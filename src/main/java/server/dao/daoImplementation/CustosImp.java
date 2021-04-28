package server.dao.daoImplementation;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import server.connect.Db;
import server.dao.daoInterfaces.CustoInterface;
import server.entity.Custo;

public class CustosImp implements CustoInterface{

	@Override
	public List<Custo> getAllCustos() {
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		List<Custo> custos = new ArrayList<Custo>();
		try {
			sql.append("SELECT * FROM custos");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				custos.add(montarCusto(rs));
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return custos;
	}

	@Override
	public void addCusto(Custo custo) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("INSERT INTO custos (DESCRICAO,VALOR_MENSAL,ATIVO) VALUES ");
			sql.append("('").append(custo.getDescricaoCusto() + "',");
			sql.append("'" + custo.getValorMensal() + "',");
			sql.append("'" + custo.getAtivo() + "')");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	@Override
	public Custo getCusto(Integer id) {
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		try {
			sql.append("SELECT * FROM custos ");
			sql.append("WHERE ID = '").append(id + "'");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				return montarCusto(rs);
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return null;
	}
	
	@Override
	public void alterarCusto(Custo custo) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE custos set DESCRICAO = '").append(custo.getDescricaoCusto() + "', ");
			sql.append("VALOR_MENSAL = '").append(custo.getValorMensal() + "', ");
			sql.append("ATIVO = '").append(custo.getAtivo() + "' ");
			sql.append("WHERE ID = '").append(custo.getId() + "'");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	@Override
	public void vincularCusto(Custo custo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirCusto(Integer id) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM custos WHERE id = '").append( id + "'");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

	private Custo montarCusto(ResultSet rs) throws Exception {
		Custo custo = new Custo();
		custo.setId(rs.getInt("ID"));
		custo.setDescricaoCusto(rs.getNString("DESCRICAO"));
		custo.setValorMensal(rs.getDouble("VALOR_MENSAL"));
		custo.setAtivo(rs.getInt("ATIVO"));
		return custo;
	}

}
