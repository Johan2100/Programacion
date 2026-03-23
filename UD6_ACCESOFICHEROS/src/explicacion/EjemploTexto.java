package explicacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EjemploTexto {
	
	static List<String> nombres = new ArrayList<>();
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
	
		try {
			leerNombres();
		} catch (IOException e) {
			System.err.println("No se ha podido hacer la lectura");
		}
		
		for (String s : nombres) {
			System.out.println(s);
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Introduce nombre: ");
			nombres.add(sc.nextLine());
		}
		try {
			guardarNombres();
		} catch (IOException e) {
			System.err.println("No se ha podido guardar el archivo");
		}
	
	}
	
	
	private static void leerNombres2() throws IOException{

		System.out.println("nombre del fichero: ");
		String nomFich = sc.nextLine();
		
		File file = new File(nomFich+".txt");
		if(!file.exists())
			return;
		
		
		//1. ABRIR FICHERO PARA LEER
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		
		String lineaTxt;
		while((lineaTxt = buffer.readLine()) != null) {
			nombres.add(lineaTxt+"\n");
		}
		buffer.close();
		
	}
	
	
	//El FileNotFoundException hereda de IOException
	private static void leerNombres() throws IOException {
		
		System.out.println("nombre del fichero: ");
		String nomFich = sc.nextLine();
		
		File file = new File(nomFich+".txt");
		if(!file.exists())
			return;
		
		
		//1. ABRIR FICHERO PARA LEER CARACTERES
		FileReader fr = new FileReader(file);
		
		//2. HACER LA LECTURA
		String s = "";
		
		int c;
		//El fr.read() devuelve -1, cuando ya ha terminado de leer el archivo. 
		while( (c = fr.read()) != -1) {
			s += (char)c;
		}
		
		
		 for (String n : s.split("\n")) {
			 nombres.add(n);
			
		}
		//3. CERRAR 
		fr.close();
		
	}


	private static void guardarNombres() throws IOException {
		
		//1. ABRIR EL FICEHRO PARA LA ESCRITURA 
		//FileOutPutStream: Escribir bytes
		//FileWriter: escribir caracteres
		System.out.println("En qué fichero quiere guardar ? ");
		String nomFich = sc.nextLine();
		
		//Segundo parámetro me indica si puedo sobreescribir el archivo en caso de que exista, 
		//Si es true -> No sobreescribe 
		//Si es false -> Si sobreescribe 
		FileWriter fw = new FileWriter(nomFich+".txt",true);
		
		/** OTRA OPCION 
		trycatch
		}
		try {
			FileWriter fw = new FileWriter(nomFich);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		 */
		
		//2. ESCRIBIMOS
		for (String a : nombres) {
			fw.write(a+"\n");
		}
		//3. CERRAMOS
		fw.close();
		
		
	}
}
