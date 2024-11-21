import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


        public static void main(String[] args) throws IOException {
            try (ServerSocket serverSocket = new ServerSocket(12345)) {
                System.out.println("Server is running...");
                boolean Running = true;

                while (Running) {
                    try (Socket clientSocket = serverSocket.accept();
                         ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                         ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream())) {

                        System.out.println("Client connected.");

                        Object received = input.readObject();
                        if (received instanceof String && received.equals("Q")) {
                            System.out.println("Client requested shutdown. Shutting down server...");
                            Running = false;
                        } else if (received instanceof Shape) {
                            Shape shape = (Shape) received;
                            double area = shape.calculateArea();
                            System.out.println("Client requested the area of " + shape.getDescription() + ". Answer is " + area);
                            output.writeObject("Answer is: " + area);
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
        }
    }

}
