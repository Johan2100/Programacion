package examenesPractica.ejerEmpresa.model;

public class Factura extends ApunteEconomico {
	private int idFactura;
	private String emisor;
	
	//CONSTRUCTOR -- 
	public Factura(int code, double importe, String concepto, int idFactura, String emisor) {
		super(code, importe, concepto);
		this.idFactura = idFactura;
		this.emisor = emisor;
	}

	//GETTER AND SETTER -- 
	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	//METHODS -- 
	@Override
	public void descripcion() {
		System.out.println(concepto);
	}
 
	
	
	
	
}
