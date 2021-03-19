package com.example.clienteandroidtcp;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPcliente extends Thread{

    private BufferedWriter bwriter;
    private MainActivity ref;

    public void run() {
        try {
            Socket socket = new Socket("10.0.2.2", 5000);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bwriter = new BufferedWriter(osw);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void escribir(String string) {
        Gson gson = new Gson();

        String action = string;

        //Serializacion
        String coordStr = gson.toJson(action);

        new Thread(
                () -> {
                    try {
                        bwriter.write(coordStr + "\n");
                        bwriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}
