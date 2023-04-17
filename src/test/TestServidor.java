package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import servidor.Servidor;

public class TestServidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(Servidor.PUERTO);
			System.out.println("Servidor de fechas corriendo...");
			while(true) {
				Socket cliente = servidor.accept();
				
				InputStream in = cliente.getInputStream();
				OutputStream out = cliente.getOutputStream();
				
				//Leer el nombre del empleado
				DataInputStream dis = new DataInputStream(in);
				String nombre = dis.readUTF();
				String ingreso = Servidor.getFecha(nombre);
				//Enviar el resultado al cliente
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF(ingreso);
				cliente.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(ingreso);

	}

}
