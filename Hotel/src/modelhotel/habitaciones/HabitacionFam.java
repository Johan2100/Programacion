package modelhotel.habitaciones;

public class HabitacionFam extends Habitacion{
	private int numCamDo;

	//CONSTRUCTOR -- 
	public HabitacionFam(int numHab, int numCamas, double precioNoche) {
		super(numHab, numCamas, precioNoche);
		// TODO Auto-generated constructor stub
	}

	public HabitacionFam(int numHab, int numCamas, double precioNoche, int numCamDo) {
		super(numHab, numCamas, precioNoche);
		this.numCamDo = numCamDo;
	}

	//GETTER AND SETTER -- 
	
	public int getNumCamDo() {
		return numCamDo;
	}

	public void setNumCamDo(int numCamDo) {
		this.numCamDo = numCamDo;
	}
	
	
	
	//METODOS -- 

	public int plazaTotal() {
		return numCamDo*2 + numCamas;
	}
	
	

}
