package ejemploMAP.prueba1.main;

import java.util.HashMap;
import java.util.Map;

import ejemploMAP.prueba1.model.Alumno;

public class mainMAP {
	public static void main(String[] args) {
		
	//MASHMAP: GUARDA LAS CLAVES EN UN HASHSET
	Map<String,Alumno> alumnos = new HashMap<>();
	
	//alumnos.put(clave, valor);
	
	alumnos.put("1122", new Alumno("Johan"));
	System.out.println(alumnos.size());
	alumnos.put("1122", new Alumno("Johan")); // Este no se introduce porque la clave es la misma;
	
	alumnos.put("5566", new Alumno("Yimmy"));
	
	//Obtener por clave:
	alumnos.get("1122");
	alumnos.get("5566");
	
	
	
	
	}

}
