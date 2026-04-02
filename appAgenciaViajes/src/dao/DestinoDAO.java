package dao;

import java.io.EOFException;
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
		File temp = new File("datos\\temp.dat");
	
		boolean encontrado = false;
		
		if (!datos.exists() || datos.length() == 0) {
		    return false;
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos)); 
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp)) ) {
				
				boolean fin = false;
				
				while(!fin) {
					try {
						Destino d = (Destino) ois.readObject();
						if(!d.getNombreDestino().equals(nombre))
							oos.writeObject(d);
						else
							encontrado =  true;
						
					}catch(EOFException e) {
						fin = true;
					}
				}//while
				
		}
		datos.delete();
		temp.renameTo(datos);
		
		
		return encontrado;
	}

	public static boolean update(Destino des) throws ClassNotFoundException, IOException {
		File temp = new File("datos\\temp.dat");
		
		boolean encontrado = false;
		
		if (!datos.exists() || datos.length() == 0) {
		    return false;
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos)); 
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp)) ) {
				
				boolean fin = false;
				
				while(!fin) {
					try {
						Destino d = (Destino) ois.readObject();
						if(!(d.getNombreDestino().equals(des.getNombreDestino()))) {
							oos.writeObject(d);
						}else
							oos.writeObject(des);
							encontrado =  true;
						
						
					}catch(EOFException e) {
						fin = true;
					}
				}//while
				
		}
		datos.delete();
		temp.renameTo(datos);
		
		
		return encontrado;
		
	}
	
	public static Destino get(String nombre) throws FileNotFoundException, IOException, ClassNotFoundException {
	
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos))) {
				
				boolean fin = false;
				
				while(!fin) {
					try {
						Destino d = (Destino) ois.readObject();
						if(d.getNombreDestino().equals(nombre)) {
							return d;
						}
					}catch(EOFException e) {
						fin = true;
					}
				}//while
				
		}
		return null;
	}
	
	
	
	
	
	public static boolean existeDestino(Destino d ) {
		return false;
	}

	public static void listarDestinos() throws FileNotFoundException, IOException, ClassNotFoundException {
		if(!datos.exists() || datos.length() == 0) {
			return;
		}
		
		try (ObjectInputStream ois = new ObjectInputStream (new FileInputStream(datos))){
		
			boolean fin = false;
			
			while(!fin) {
				try {
					Destino d = (Destino) ois.readObject();
					System.out.println(d);
				}catch(EOFException e) {
					fin = true;
				}
			}
			
			
			
		}
		
	}
	
	
	
	
}
