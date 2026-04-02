package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.Reserva;

public class ReservaDAO {
	private static File datos = new File ("datos\\Reservas.dat");
	static Map<Long,Reserva> reservas = new HashMap<Long,Reserva>();
	
	
	
	public ReservaDAO(File datos) {
		ReservaDAO.datos = datos;
	}
	
	public static boolean insert(Reserva reserva) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		if(!datos.exists()) {
			reservas.put(reserva.getCodReserva(), reserva);
			return save();
		}else {
			
			
			
			reservas.put(reserva.getCodReserva(), reserva);
			return save();
			
		}
		
		
		
		
		
	}
	
	public static Reserva get(long codReserva) throws ClassNotFoundException, FileNotFoundException, IOException {
		if(datos.length() == 0)
			return null;
		
		if(reservas.containsKey(codReserva)) {
			return reservas.get(codReserva);
		}else {
			System.out.println("No se ha encontrado ese código de Reserva");
		}
		
		return null;
	}

	
	
	public static boolean delete(long codReserva) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(datos.length() == 0)
			return false;
		boolean eliminado = false;
		if(reservas.containsKey(codReserva)) {
			reservas.remove(codReserva);
			eliminado = true;
		}
		save();
		return eliminado;
	
	}
	public static boolean update(Reserva uptReserva) throws FileNotFoundException, IOException, ClassNotFoundException {
		Set<Long> keySet = reservas.keySet();
		boolean cambiado = false;
		for (Long d : keySet) {
			if(d == uptReserva.getCodReserva()) {
				reservas.get(d).setCliente(uptReserva.getCliente());
				reservas.get(d).setDestino(uptReserva.getDestino());
				reservas.get(d).setFecha(uptReserva.getFecha());
				cambiado = true;
			}
		}
		save();
		return cambiado;
		
	}
	
	private static boolean save() throws FileNotFoundException, IOException {
		boolean guardado = false;
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datos))){
			oos.writeObject(reservas);
			guardado = true;
		}catch(EOFException e ) {
			System.out.println("No se ha guardado el MAP");
		}
		
		return guardado;
		
	}
	
	public static void listarReservas() {
		Set<Long> codReservas = reservas.keySet();
		for (Long s : codReservas) {
			System.out.println("-Codigo: "+s+" -Valor: "+reservas.get(s));
		}
		
	}
	
	public static long lastMapCode() throws FileNotFoundException, IOException, ClassNotFoundException {
		Long lastCode = 1L;
		
		if(datos.exists()) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datos))){
				
				Map<Long,Reserva> d = ((Map<Long,Reserva>) ois.readObject());
				reservas = d;
			}
			
		}
		
		Set<Long> codReservas = reservas.keySet();
		for(Long s : codReservas) {
			lastCode = s;
		}
		return ++lastCode;
	}
	
	
	
	
	
	public File getDatos() {
		return datos;
	}
	public void setDatos(File datos) {
		ReservaDAO.datos = datos;
	}
	public Map<Long, Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(Map<Long, Reserva> reservas) {
		ReservaDAO.reservas = reservas;
	}

	
	
	
}
