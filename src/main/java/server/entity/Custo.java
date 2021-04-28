package server.entity;

public class Custo {
	
	private Integer id;
	private String  descricaoCusto;
	private Double  valorMensal;
	private Integer ativo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricaoCusto() {
		return descricaoCusto;
	}
	public void setDescricaoCusto(String descricaoCusto) {
		this.descricaoCusto = descricaoCusto;
	}
	public Double getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(Double valorMensal) {
		this.valorMensal = valorMensal;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
}
