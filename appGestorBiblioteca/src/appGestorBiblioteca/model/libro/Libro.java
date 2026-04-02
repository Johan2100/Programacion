package appGestorBiblioteca.model.libro;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Libro implements Comparable<Libro>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1801371165992318145L;
	private String titulo, autor;
	private long ISBN;
	private int stock;
	private LocalDate fechaP;
	
	public Libro(String título, String autor, long iSBN, int stock) {
		this.titulo = título;
		this.autor = autor;
		ISBN = iSBN;
		this.stock = stock;
	}
	
	public LocalDate getFechaP() {
		return fechaP;
	}

	public void setFechaP(LocalDate fechaP) {
		this.fechaP = fechaP;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String título) {
		this.titulo = título;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}



	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Libro o) {
		// TODO Auto-generated method stub
		return this.titulo.compareTo(o.getTitulo());
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", stock=" + stock+"]";
	}

	public String toStringFecha() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", stock=" + stock + ", fecha="
				+ fechaP.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "]";
	}
	
	
	
	
	
	
}
