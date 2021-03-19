package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class TCPserver extends Thread{
	
	String llave;
	private Main ref;
	
	public void run () {
		
			try {
				ServerSocket server = new ServerSocket(5000);
				System.out.println("Esperando cliente...");
				Socket socket = server.accept();
				System.out.println("Cliente esta conectado");

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				// Hacer que el objeto is tenga la capacidad de leer Strings completos
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader breader = new BufferedReader(isr);

				while (true) {
					// Esperando mensaje
					System.out.println("Esperando mensaje...");
					String mensajeRecibido = breader.readLine(); //BW::X::Y::ALTO::ANCHO
					System.out.println(mensajeRecibido);

					Gson gson = new Gson();

					//Deserializacion
					llave = gson.fromJson(mensajeRecibido, String.class);
					ref.actions(llave);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	public void setMain(Main main) {
		this.ref =  main;
		
	}
	
}
