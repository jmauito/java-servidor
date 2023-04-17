package servidor;

import java.text.*;
import java.util.*;

public class Servidor {
	public static final int PUERTO = 2022;
	
	//Cada método que funciona en el servidor se le llama servicio
	public static String getFecha(String nombre) {
		Date date = new Date();
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "Empleado: " + nombre + "Ingreso: " + fecha.format(date);
	}
	
}
