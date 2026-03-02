package examenesPractica.ejerEmpresa.model;

import java.time.LocalDate;

public class GastoEmpresa extends ApunteEconomico implements Comparable<GastoEmpresa> {
	
	private LocalDate fecha;
	private String DNIResponsable;
	//CONSTRUCTOR -- 
	public GastoEmpresa(int code, double importe, String concepto, LocalDate fecha, String dNIResponsable) {
		super(code, importe, concepto);
		this.fecha = fecha;
		DNIResponsable = dNIResponsable;
	}
	
	//GETTER AND SETTER-- 
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDNIResponsable() {
		return DNIResponsable;
	}
	public void setDNIResponsable(String dNIResponsable) {
		DNIResponsable = dNIResponsable;
	}
	
	
	
	@Override
	public String toString() {
		return "GastoEmpresa [fecha=" + fecha + ", DNIResponsable=" + DNIResponsable + "]";
	}

	//METHODS -- 
	@Override
	public void descripcion() {
		System.out.println(concepto);		
	}

	@Override
	public int compareTo(GastoEmpresa o) {  //DEVOLVER NEGATIVO SI THIS ( EL QUE LLAMA ) ES MAYOR 
											//DEVOLVER POSITIVO SI THIS ( EL QUE LLAMA ) ES MENOR 
		return (int)(o.getImporte() - this.getImporte());
	}

	
	

}
