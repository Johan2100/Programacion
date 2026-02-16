package ejemplosSET;

import java.util.Objects;

public class AlumnoSET {
	
	private String nif;
	private double nota;
	
	//CONSTRUCTOR ---
	public AlumnoSET(String nif, double nota) {
		super();
		this.nif = nif;
		this.nota = nota;
	}
	
	//GETTER AND SETTER --
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}

	//ToString  --
	@Override
	public String toString() {
		return "AlumnoSET [nif=" + nif + ", nota=" + nota + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlumnoSET other = (AlumnoSET) obj;
		return Objects.equals(nif, other.nif);
	}
	
	
	
	
	
	
	

}
