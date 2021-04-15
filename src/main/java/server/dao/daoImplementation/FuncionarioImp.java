package server.dao.daoImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import server.connect.*;

import server.dao.daoInterfaces.FuncionarioInterface;
import server.entity.Funcionario;

public class FuncionarioImp implements FuncionarioInterface {

	@Override
	public void cadastrarFuncionario(Funcionario funcionario) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("INSERT INTO funcionario (Nome, ValorHoras, Ativo, HorasTrabalhadas) VALUES (");
			sql.append("'" + funcionario.getNome() + "',");
			sql.append("'" + funcionario.getValorHoras() + "',");
			sql.append("'" + funcionario.getAtivo() + "',");
			sql.append("'" + 0 + "')");
			Db.executaDataManipulation(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void calcularSalario(Funcionario funcionario) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE funcionario set HorasTrabalhadas = '").append(funcionario.getHorasTrabalhadas() + "', ");
			sql.append(" dtTrabalhado = '").append(funcionario.getDtTrabalhado() + "'");
			sql.append(" WHERE Codigo = '").append(funcionario.getCodigo() + "'");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("SELECT * FROM funcionario order by Nome");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				funcionarios.add(instanciarFuncionario(rs));
			}
		}catch(Exception e) {
			System.out.print(e.getStackTrace());
		}
		return funcionarios;
	}
	
	@Override
	public List<Funcionario> gastosPeriodo(HashMap<String, Object> params) {
		List<Funcionario> funcionarios = new ArrayList<>();
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" SELECT * FROM funcionario ");
			sql.append(" WHERE dtTrabalhado BETWEEN '").append(params.get("DT_INICIO") + "'");
			sql.append(" AND '").append(params.get("DT_FIM") + "'");
			sql.append(" order by Codigo");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				funcionarios.add(instanciarFuncionario(rs));
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return funcionarios;
	}
	
	private Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(rs.getInt("Codigo"));
		funcionario.setNome(rs.getString("Nome"));
		funcionario.setValorHoras(rs.getDouble("ValorHoras"));
		funcionario.setHorasTrabalhadas(rs.getInt("HorasTrabalhadas"));
		if(rs.getDate("dtTrabalhado") != null) {
			funcionario.setDtTrabalhado(LocalDate.parse(rs.getDate("DtTrabalhado").toString()));
		}
		funcionario.setAtivo(rs.getInt("Ativo"));
		return funcionario;
	}

	
}
