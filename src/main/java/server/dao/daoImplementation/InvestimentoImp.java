package server.dao.daoImplementation;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import server.connect.Db;
import server.dao.daoInterfaces.InvestimentoInterface;
import server.entity.Investimento;

public class InvestimentoImp  implements InvestimentoInterface {

	@Override
	public void adicionarInvestimento(Investimento investimento) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("INSERT INTO investimento (TIPO_INVESTIMENTO, RENDA_MENSAL, VALOR_INVESTIDO, DT_INICIO, DT_FIM) VALUES (");
			sql.append("'" + investimento.getTipoInvestimento() + "',");
			sql.append("'" + investimento.getRendaDiaria() + "',");
			sql.append("'" + investimento.getValorInvestido() + "',");
			sql.append("'" + investimento.getDtInicio() + "',");
			sql.append("'" + investimento.getDtFim() + "')");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	@Override
	public void alterarInvestimento(Investimento investimento) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("UPDATE investimento SET ");
			sql.append("TIPO_INVESTIMENTO = '").append(investimento.getTipoInvestimento() + "', ");
			sql.append("RENDA_MENSAL = '").append(investimento.getRendaDiaria() + "', ");
			sql.append("VALOR_INVESTIDO = '").append(investimento.getValorInvestido() + "', ");
			sql.append("DT_INICIO = '").append(investimento.getDtInicio() + "', ");
			sql.append("DT_FIM = '").append(investimento.getDtFim() + "' ");
			sql.append("WHERE ID = '").append(investimento.getId() + "'");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	@Override
	public List<Investimento> getAllInvestimentos() {
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		List<Investimento> investimentos = new ArrayList<>();
		try {
			sql.append("SELECT * FROM investimento");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				investimentos.add(criarInvestimento(rs));
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return investimentos;
	}
	
	@Override
	public Investimento getInvestimentoById(Integer id) {
		StringBuilder sql = new StringBuilder();
		Investimento investimento = null;
		ResultSet rs = null;
		try {
			sql.append("SELECT * FROM investimento WHERE id = '").append(id +"'");
			rs = Db.executaSelect(sql);
			while(rs.next()) {
				investimento = criarInvestimento(rs);
			}
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return investimento;
	}
	
	@Override
	public void excluirInvestimento(Integer id) {
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("DELETE FROM investimento WHERE ID = ").append("'" + id +"'");
			Db.executaDataManipulation(sql);
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	private Investimento criarInvestimento(ResultSet rs) throws Exception {
		Investimento investimento = new Investimento();
		investimento.setId(rs.getInt("ID"));
		investimento.setTipoInvestimento(rs.getString("TIPO_INVESTIMENTO"));
		investimento.setValorInvestido(rs.getDouble("VALOR_INVESTIDO"));
		investimento.setRendaDiaria(rs.getDouble("RENDA_MENSAL"));
		investimento.setDtInicio(LocalDate.parse(rs.getString("DT_INICIO")));
		investimento.setDtFim(LocalDate.parse(rs.getString("DT_FIM")));
		return investimento;
	}
}
