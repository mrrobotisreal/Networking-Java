//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.net.ServerSocket;
//import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(54555)) {
            while (true) {
                new Echoer(serverSocket.accept()).start();
            }
        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
            e.printStackTrace();
        }
    }
}



//    Socket socket = serverSocket.accept();
//                System.out.println("Client connected on port 54555");
//                        BufferedReader input = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()));
//                        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//                        String echoString = input.readLine();
//                        try {
//                        Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                        System.out.println("Thread interrupted");
//                        }
//                        if (echoString.equals("exit")) {
//                        break;
//                        }
//                        output.println("Echo from server: " + echoString);
