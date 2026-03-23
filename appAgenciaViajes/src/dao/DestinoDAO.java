package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Destino;

public class DestinoDAO {
	private static File datos = new File("datos\\GestionViajes.dat");;
	
	
	public File getDatos() {
		return datos;
	}

	public void setDatos(File datos) {
		DestinoDAO.datos = datos;
	}

	public static boolean insert(Destino d) throws FileNotFoundException, IOException {
		if(existeDestino(d))
			return false;
		
		if(datos.exists()) {
			try(ObjectOutputStreamADD oos = new ObjectOutputStreamADD(new FileOutputStream(datos,true))){
				oos.writeObject(d);
				return true;
			}catch(IOException e) {
				e.printStackTrace();
				return false;
			}
		}else {
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datos,true))){
				oos.writeObject(d);
				return true;
			}catch(IOException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
	}
	
	public static boolean delete(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File("datos\\temp");
		
		if(datos.length() == 0)
			return false;
	
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos));
		Destino des;
		while((des = (Destino)ois.readObject()) != null) {
			if(!(des.getNombreDestino().equals(nombre))) {
				try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f,true))){
					oos.writeObject(des);
				}catch(IOException e) {
					e.printStackTrace();
					return false;
				}
			
			}
		}
		
		
		
		return true;
		
	}

	public static boolean update(String nombre) {
		return false;
	}
	public static boolean existeDestino(Destino d ) {
		return false;
	}
	
	
	
	
}
