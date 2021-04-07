package server.entity;

public class Funcionario {
	
	private Integer codigo;
	private String  nome;
	private Double  valorHoras;
	private Integer horasTrabalhadas;
	private Boolean ativo;
	
	public Funcionario() {
		
	}
	
	public Funcionario(Integer codigo, String nome, Double valorHoras, Integer horasTrabalhadas, Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.valorHoras = valorHoras;
		this.horasTrabalhadas = horasTrabalhadas;
		this.ativo = ativo;
	}
	
	public Funcionario(String nome, Double valorHoras, Integer horasTrabalhadas, Boolean ativo) {
		this.nome = nome;
		this.valorHoras = valorHoras;
		this.horasTrabalhadas = horasTrabalhadas;
		this.ativo = ativo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValorHoras() {
		return valorHoras;
	}
	public void setValorHoras(Double valorHoras) {
		this.valorHoras = valorHoras;
	}
	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
