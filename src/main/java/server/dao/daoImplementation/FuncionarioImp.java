package server.dao.daoImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import server.connect.*;

import server.dao.daoInterfaces.FuncionarioInterface;
import server.entity.Funcionario;

public class FuncionarioImp implements FuncionarioInterface {

	private Connection conn;

	public FuncionarioImp(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void cadastrarFuncionario(Funcionario funcionario) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO funcionario " + "(Nome, ValorHoras, HorasTrabalhadas, Ativo) "
					+ "VALUES " + "(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, funcionario.getNome());
			st.setDouble(2, funcionario.getValorHoras());
			st.setDouble(3, funcionario.getHorasTrabalhadas());
			st.setBoolean(4, funcionario.getAtivo());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					funcionario.setCodigo(id);
				}
				Db.closeResultSet(rs);
			} else {
				System.out.println("Nenhuma linha foi alterada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.closeStatement(st);
		}

	}

	@Override
	public void calcularSalario(Funcionario funcionario) {
		PreparedStatement st = null;
		try {
			Double salario = funcionario.getHorasTrabalhadas() * funcionario.getValorHoras();
			 st = conn.prepareStatement(
                     "UPDATE funcionario "
                     + "SET SalarioMensal = ?"
                     + "WHERE Codigo = ?");
			 
			 st.setDouble(1, salario);
			 st.setInt(2, funcionario.getCodigo());
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Funcionario> getFuncionarios() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT Codigo, Nome, ValorHoras, HorasTrabalhadas, Ativo"
					+ "FROM funcionario" + "ORDER BY Name");

			rs = st.executeQuery();

			List<Funcionario> list = new ArrayList<>();

			while (rs.next()) {

				Funcionario funcionario = instanciarFuncionario(rs);
				list.add(funcionario);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Db.closeStatement(st);
			Db.closeResultSet(rs);
		}
		return null;
	}

	 private Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
	      	Funcionario funcionario = new Funcionario();
	      	funcionario.setCodigo(rs.getInt("Codigo"));
	      	funcionario.setNome(rs.getString("Nome"));
	      	funcionario.setValorHoras(rs.getDouble("ValorHoras"));
	      	funcionario.setHorasTrabalhadas(rs.getInt("HorasTrabalhadas"));
	      	funcionario.setAtivo(rs.getBoolean("Ativo"));
	      	return funcionario;
	    }

	@Override
	public void registrarHorasTrabalhadas(Funcionario funcionario) {
		 PreparedStatement st = null;
	       try{
	           st = conn.prepareStatement(
	                     "UPDATE funcionario "
	                     + "SET HorasTrabalhadas = ?"
	                     + "WHERE Codigo = ?");
	           
	           st.setInt(1, funcionario.getHorasTrabalhadas());
	           st.setInt(2, funcionario.getCodigo());
	           
	            st.executeUpdate();

	       }catch(SQLException e){
	          e.printStackTrace();
	       }finally{
	           Db.closeStatement(st);
	       }
		
	}
}
