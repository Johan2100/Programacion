package examenesPractica.ejerEmpresa.model;

import java.util.Objects;

public abstract class ApunteEconomico {
	protected int code;
	protected double importe;
	protected String concepto;
	
	//CONSTRUCTOR -- 
	public ApunteEconomico(int code, double importe, String concepto) {
		this.code = code;
		this.importe = importe;
		this.concepto = concepto;
	}
	
	//GETTER AND SETTER -- 
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	//HASH AND EQUALS
	
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApunteEconomico other = (ApunteEconomico) obj;
		return code == other.code;
	}
	
	

	
	
	@Override
	public String toString() {
		return "ApunteEconomico [code=" + code + ", importe=" + importe + ", concepto=" + concepto + "]";
	}

	//METHODS -- 
	public int getCodigo() {
		return Integer.parseInt((code+"").substring(0,4));
	}
	
	
	public abstract void descripcion();

}
