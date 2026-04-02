package appGestorBiblioteca.model.gestor;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


import appGestorBiblioteca.model.libro.Libro;

public class GestorLibros implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2365590906319958836L;
	private static File datosLibros = new File("datos\\GestorLibros.dat");
	private Libro libros;
	private static File datosMap = new File("datos\\GestorLibroMAP.dat");
	public static Map<String,Libro> listaLibros = new HashMap<String,Libro>();

	
	//GETTER AND SETTER 
	public static File getDatosLibros() {
		return datosLibros;
	}
	public static void setDatosLibros(File datosLibros) {
		GestorLibros.datosLibros = datosLibros;
	}
	public Libro getLibros() {
		return libros;
	}
	public void setLibros(Libro libros) {
		this.libros = libros;
	}

	
	//MÉTODOS CRUD ISBN -- 
	
	//CREATE 
	/**
	 * El método permite insertar libros al fichero en formato objeto Libro
	 * @param libro
	 * @throws FileNotFoundException, IOException
	 * 
	 */
	public static void insertByISBN (Libro libro) throws FileNotFoundException, IOException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datosLibros))){	
			oos.writeObject(libro);
			System.out.println("Introducido correctamente");
		}
	}
	
	//DELETE
	/**
	 * El método permite la eliminación de un libro del fichero mediante el ISBN,
	 * este método llama containsBook() para ver si existe un libro dentro del fichero y de tal manera actuar para eliminarlo. 
	 * @param ISBN
	 * @return true, si el archivo se eliminó; false, si el archivo no se ha encontrado o eliminado. 
	 * @throws FileNotFoundException, IOException, ClassNotFoundException
	 */
	public static boolean deleteByISBN(Long ISBN) throws FileNotFoundException, IOException, ClassNotFoundException {
		File temp = new File("datos\\temp.dat");
		boolean eliminado = true;
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp)); 
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datosLibros))){
			if(containsBookByISBN(ISBN) == true) {
				boolean fin = false;
				
				while(!fin) {
					try {
						Libro l = (Libro)ois.readObject();
						if (l.getISBN() != ISBN) {
							oos.writeObject(l);
						}else
							eliminado = true;
							
					}catch(EOFException e) {
						fin = true;
					}
				}
			}else
				eliminado = false;
		}
		
		datosLibros.delete();
		temp.renameTo(datosLibros);
		
		return eliminado;
	}
	
	//GET 
	/**
	 * Método que nos devuelve un objeto libro
	 * @param ISBN
	 * @return Un objecto Libro, o si no hay devuelve "null"
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Libro getByISBN(Long ISBN) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(containsBookByISBN(ISBN) == true) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datosLibros))){
					boolean fin = false;
					while(!fin) {
						try {
							Libro l = (Libro)ois.readObject();
							if (l.getISBN() == ISBN)
								return l;
							
						}catch(EOFException e) {
							fin = true;
						}
					}			
				}
		}
		return null;
	}
	
	/**
	 * Método para poder actualizar la información del libro mediante el ISBN, modificando este el autor y el titulo, siempre siendo el mismo ISBN
	 * @param uptLibro
	 * @return true: si se ha actualizado el libro; false: si no se ha actualizado o no se ha encontrado el ISBN
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	
	public static boolean updateByISBN (Libro uptLibro) throws FileNotFoundException, ClassNotFoundException, IOException {
		File temp = new File("datos\\temp.dat");
		boolean actualizado = false;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datosLibros));
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(temp))){
			if(containsBookByISBN(uptLibro.getISBN()) == true) {
				boolean fin = false;
				while(!fin) {
					try {
						Libro l = (Libro)ois.readObject();
						if(l.getISBN() == uptLibro.getISBN()) {
							l.setAutor(uptLibro.getAutor());
							l.setTitulo(uptLibro.getTitulo());
							actualizado = true;
							oos.writeObject(l);
						}else {
							oos.writeObject(l);
						}
						
					}catch(EOFException e) {
						fin = true;
					}
				}	
			}
		}
		
		
		return actualizado;
	}
	
	//CONTAINS BOOK 
	/**
	 * Método creado para saber si existe o contiene dicho ISBN en el fichero
	 * @param ISBN
	 * @return true: si existe el libro en el fichero; false: si no existe el libro en el fichero. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static boolean containsBookByISBN(Long ISBN) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean encontrado = false;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datosLibros))){
			boolean fin = false;
			while(!fin) {
				try {
					Libro l = (Libro)ois.readObject();
					if (l.getISBN() == ISBN)
						encontrado = true;
					
				}catch(EOFException e) {
					fin = true;
				}
			}			
		}
		return encontrado;
	}
	
	
	
	
	
	/**
	 * Actualización de 2º Version implementando un map para guardar todos los libros en un solo objeto. 
	 * En esta version se trabajara con el nombre del titulo y no con el ISBN
	 */
	//MÉTODOS CRUD "VERSION 2" MAP -- 
	
	/**
	 * El método permite insertar libros al map listaLibros, dichos libros no se van a repetir y en caso de poner el mismo 
	 * libro y distinta cantidad se quedará con el último insert
	 * @param libro
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void insert (Libro libro) throws FileNotFoundException, IOException {
			listaLibros.put(libro.getTitulo(), libro);
			save();
	}
	
	/**
	 * Permite borrar el libro mediante nombre 
	 * @param bookName
	 * @return True: el libro se ha borrado, False: el libro no se ha podido eliminar
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public static boolean delete(String bookName) throws FileNotFoundException, IOException {
		if(listaLibros.containsKey(bookName)){
			listaLibros.remove(bookName);
			save();
			return true;
		}
		return false;
	}
	
	/**
	 * Permite obtener un libro mediante nombre
	 * @param bookName
	 * @return Devuelve un objeto Libro
	 */
	public static Libro get(String bookName) {
		
		if(listaLibros.containsKey(bookName)){
			return listaLibros.get(bookName);
		}
		return null;
	}
	/**
	 * Imprime los libros contenidos en la colección MAP 
	 */
	public static void listarLibros() {
		List<Libro> listarLibros = new ArrayList<Libro>(listaLibros.values());
		listarLibros.sort(null);
		System.out.println("Listado: ");
		for (Libro l : listarLibros) {
			System.out.println(l);
		}
	}
	
	/**
	 * Este método sirve para actualizar el MAP cuando se hace alguna modificación dentro de ella
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void save() throws FileNotFoundException, IOException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datosMap))){
			oos.writeObject(listaLibros);
		}
	}
	
	/**
	 * El método se inicializa al empezar el main para recuperar los datos de anteriores ejecuciones 
	 * permitiendo la persistencia de datos y seguir trabajando en el mismo MAP. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void lastSave() throws FileNotFoundException, IOException, ClassNotFoundException {
		if(datosMap.exists() || datosMap.length() != 0) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datosMap))){
				Map<String,Libro> tempM = (Map<String,Libro>)ois.readObject();
				listaLibros = tempM;
			}
		}
	}
	
	
	
	

}
