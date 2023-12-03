import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port yang akan digunakan oleh server
        
        try {
            // Membuat server socket
            ServerSocket ServerSocket = new ServerSocket(port);
            
            System.out.println("Server berjalan dan mendengarkan di port " + port);
            
            while (true) {
                // Menerima koneksi dari client
                Socket clientSocket = ServerSocket.accept();
                System.out.println("Terhubung dengan client " + clientSocket.getInetAddress());
                
                // Membaca input dari client
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String clientName = reader.readLine();
                
                System.out.println("Menerima nama dari client: " + clientName);
                
                // Mengirim pesan balasan ke client
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println("Halo, " + clientName + "! Nama Anda telah diterima oleh server.");
                
                // Menutup koneksi dengan client
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

