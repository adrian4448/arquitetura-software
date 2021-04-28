package server.entity;

public class Maquina {
	
	private Integer id;
	private String  descMaquina;
	private Double  renda;
	
	public Maquina() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescMaquina() {
		return descMaquina;
	}
	public void setDescMaquina(String descMaquina) {
		this.descMaquina = descMaquina;
	}
	public Double getRenda() {
		return renda;
	}
	public void setRenda(Double renda) {
		this.renda = renda;
	}
}
