import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread {
    private Socket socket;

    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoeString = input.readLine();
                System.out.println("Received client input: " + echoeString);
                if (echoeString.equals("exit")) {
                    break;
                }

                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }

                output.println(echoeString);
            }
        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                //
            }
        }
    }
}
