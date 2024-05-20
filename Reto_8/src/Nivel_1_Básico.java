import java.sql.*;
	import java.util.Scanner;

		public class Nivel_1_Básico {
		    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
		    private static final String USER = "root";
		    private static final String PASS = "password";

		    public static void main(String[] args) {
		        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		             Statement stmt = conn.createStatement()) {

		            Scanner scanner = new Scanner(System.in);
		            while (true) {
		                System.out.println("1. Cines\n2. Películas\n3. Salas\n4. Salir");
		                System.out.print("Seleccione una opción: ");
		                int option = scanner.nextInt();
		                scanner.nextLine();  // consume newline

		                if (option == 4) {
		                    break;
		                }

		                switch (option) {
		                    case 1:
		                        System.out.print("Introduzca el nombre del cine: ");
		                        String nombreCine = scanner.nextLine();
		                        System.out.print("Introduzca la dirección del cine: ");
		                        String direccionCine = scanner.nextLine();
		                        stmt.executeUpdate("INSERT INTO Cines (NombreCine, Direccion) VALUES ('" + nombreCine + "', '" + direccionCine + "')");
		                        System.out.println("Cine guardado correctamente.");
		                        break;
		                    case 2:
		                        // Similar a case 1, pero para la tabla Películas
		                        break;
		                    case 3:
		                        // Similar a case 1, pero para la tabla Salas
		                        break;
		                    default:
		                        System.out.println("Opción no válida.");
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
	