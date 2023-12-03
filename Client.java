import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Alamat server
        int serverPort = 12345; // Port server
        
        try {
            // Membuat socket untuk terhubung ke server
            Socket socket = new Socket(serverAddress, serverPort);
            
            // Membaca input dari keyboard
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Masukkan nama Anda: ");
            String name = reader.readLine();
            
            // Mengirim nama ke server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(name);
            
            // Menerima pesan balasan dari server
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = responseReader.readLine();
            System.out.println("Pesan dari server: " + response);
            
            // Menutup koneksi dengan server
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
