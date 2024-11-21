import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {

        public static void main(String[] args) {
            try (Socket socket = new Socket("localhost", 12345);
                 ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                 Scanner scanner = new Scanner(System.in)) {

                boolean Running = true;

                while (Running) {
                    System.out.print("Enter 3D object name: ");
                    String objectType = scanner.nextLine();

                    if (objectType.equalsIgnoreCase("Q")) {
                        output.writeObject("Q");
                        Running = false;
                    } else if (objectType.equalsIgnoreCase("Circle")) {
                        System.out.print("Enter radius: ");
                        double radius = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        output.writeObject(new Circle(radius));
                    } else if (objectType.equalsIgnoreCase("Rectangle")) {
                        System.out.print("Enter length: ");
                        double length = scanner.nextDouble();
                        System.out.print("Enter width: ");
                        double width = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        output.writeObject(new Rectangle(length, width));
                    } else if (objectType.equalsIgnoreCase("Sphere")) {
                        System.out.print("Enter radius: ");
                        double radius = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        output.writeObject(new Sphere(radius));
                    } else if (objectType.equalsIgnoreCase("Cuboid")) {
                        System.out.print("Enter length: ");
                        double length = scanner.nextDouble();
                        System.out.print("Enter width: ");
                        double width = scanner.nextDouble();
                        System.out.print("Enter height: ");
                        double height = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        output.writeObject(new Cuboid(length, width, height));
                    } else {
                        System.out.println("Unknown object type.");
                        continue;
                    }

                    Object response = input.readObject();
                    if (response instanceof String) {
                        System.out.println("Server message: " + response);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


