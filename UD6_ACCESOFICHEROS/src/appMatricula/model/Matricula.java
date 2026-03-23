package appMatricula.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Matricula implements Serializable {
	private int code;
	private List<String> asignaturas = new ArrayList<>();


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<String> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<String> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return "Matricula [code=" + code + ", asignaturas=" + asignaturas + "]";
	}
	
	
}
