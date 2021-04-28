package server.entity;

import java.time.LocalDate;

public class Investimento {
	
	private Integer id;
	private String  tipoInvestimento;
	private LocalDate dtInicio;
	private LocalDate dtFim;
	private Double  valorInvestido;
	private Double  rendaDiaria;
	
	public Investimento() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoInvestimento() {
		return tipoInvestimento;
	}
	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}
	public LocalDate getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}
	public LocalDate getDtFim() {
		return dtFim;
	}
	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
	}
	public Double getValorInvestido() {
		return valorInvestido;
	}
	public void setValorInvestido(Double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}
	public Double getRendaDiaria() {
		return rendaDiaria;
	}
	public void setRendaDiaria(Double rendaDiária) {
		this.rendaDiaria = rendaDiária;
	}
}
