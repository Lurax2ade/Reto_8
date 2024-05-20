import java.sql.*;
import java.util.Scanner;

public class Nivel_2_Básico {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("1. Cines\n2. Películas\n3. Salas\n4. Borrar\n5. Modificar\n6. Visualizar\n7. Salir");
                System.out.print("Seleccione una opción: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // consume newline

                if (option == 7) {
                    break;
                }

                switch (option) {
                    case 1:
                        // Similar a tu caso 1 existente
                        break;
                    case 2:
                        // Similar a tu caso 2 existente
                        break;
                    case 3:
                        // Similar a tu caso 3 existente
                        break;
                    case 4:
                        // Aquí puedes agregar la lógica para borrar un registro
                        break;
                    case 5:
                        // Aquí puedes agregar la lógica para modificar un registro
                        break;
                    case 6:
                        // Aquí puedes agregar la lógica para visualizar registros
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al interactuar con la base de datos.");
            e.printStackTrace();
        }
    }
}