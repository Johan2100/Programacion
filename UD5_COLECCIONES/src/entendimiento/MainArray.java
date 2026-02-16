package entendimiento;

public class MainArray {
	
	public static void main(String[] args) {
		
	DelegadoList nombres = new DelegadoList();
	
	nombres.add("Yimmy el mejor");
	
	//QUEREMOS TENER LA POSIBILIDAD DE ACCEDER A ELEMENTOS
	// DE LA COLECCION
	String nombreChan = nombres.get(0);
	
	for (int i = 0; i < nombres.size(); i++) {
		System.out.println(nombres.get(i));
	}
	
	DelegadoListSinMas<String> cajaCadenas = new DelegadoListSinMas<String>();
	
	DelegadoListSinMas<Alumno> alumnos = new DelegadoListSinMas<>();
	
	alumnos.add(new Alumno("Carlos",10));
	alumnos.add(new Alumno("Jorge",5));
	
	for (int i = 0; i < alumnos.size(); i++) {
		System.out.println(alumnos.get(i));
		
	}
	
	
	DelegadoListSinMas<Integer> notas = new DelegadoListSinMas<>();
	
	notas.add(8);
	Integer i = 300;
	
	//PODEMOS USAR LA CALASE SIN PARAMETRIZARLA DONDE CABE TODO 
	// Y ESO ES PELIGROSO 
	DelegadoListSinMas caja = new DelegadoListSinMas();
	
	Object o = caja.get(0);
	
	}

}
