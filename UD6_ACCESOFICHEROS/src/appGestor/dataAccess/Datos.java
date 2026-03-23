package appGestor.dataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Datos {
	public static void addGasto(String mes, int dia, double gasto) throws IOException {
		File mesFile = new File("datos\\"+mes);
		
		if(!mesFile.exists()) {
			FileWriter fw = new FileWriter(mesFile,true);
			fw.write(dia+";"+gasto);
			fw.close();
		}else {
			
			FileReader fr = new FileReader(mesFile);
			FileWriter fileAux = new FileWriter("Datos\\temp");
			
			BufferedReader buffer = new BufferedReader(fr);
			
			String linea;
			boolean existeDia = false;
			while((linea = buffer.readLine())!= null) {
				if(linea.split(";")[0].equalsIgnoreCase(dia+"")){
					double nuevoGasto = Double.parseDouble(linea.split(";")[1])+gasto;
					fileAux.write(dia+";"+nuevoGasto+"\n");
					existeDia = true;
				}else {
					fileAux.write(linea+"\n");
				}
			}
			
			if(!existeDia) {
				fileAux.write(dia+";"+gasto+"\n");
			}
			buffer.close();
			fr.close();
			fileAux.close();
			
			File temp = new File("datos\\temp");
			mesFile.delete();
			temp.renameTo(mesFile);
		}
		
	}
	
	public static double gastosMes(String mes) throws IOException {
		double gastoTotal=0;
		File file = new File("datos\\"+mes);
		if(!file.exists()) {
			System.out.println("fichero no encontrado ");
		}else {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			
			String linea;
			
			while((linea = bf.readLine()) != null) {
				gastoTotal += Double.parseDouble(linea.split(";")[1]);
			}
		
			bf.close();
		}
		
		return gastoTotal;
	}
	
	public static int diaMayorGasto(String mes) throws IOException {
		File file = new File("datos\\"+mes);
		double gastoMayor = 0;
		int diaMayor = 0 ;
		
		if(!file.exists()) {
			System.out.println("Fichero no encontrado");
		}else {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			
			String linea;
			while((linea = bf.readLine()) != null) {
				if( gastoMayor < (Double.parseDouble(linea.split(";")[1])) ) {
					
					diaMayor = Integer.parseInt(linea.split(";")[0]);
					gastoMayor = Double.parseDouble(linea.split(";")[1]);
				}
			}
			bf.close();
		}
		
		return diaMayor;
	}
	
	public static void eliminarDiaMes(String mes, int dia) throws IOException {
		
		File file = new File("datos\\"+mes);
		File temp = new File("datos\\temp");
		
		if(!file.exists()) {
			System.out.println("El fichero no encontrado");
		}else {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String linea;
			
			FileWriter fw = new FileWriter(temp);
			while((linea = bf.readLine()) != null) {
				if(!(linea.split(";")[0].equals(dia+""))) {
					fw.write(linea);
				}
			}
			bf.close();
			fw.close();
			
			file.delete();
			temp.renameTo(file);
			System.out.println("Dia eliminado correctamente");
		}
	}
	

}
