
//Primero, necesitarás un formulario HTML para recoger la información del usuario. Este formulario enviará los datos al servlet cuando el usuario haga clic en el botón "Guardar", "Modificar" o "Eliminar".

/*<form action="MiServlet" method="post">
    <label for="nombreCine">Nombre del cine:</label><br>
    <input type="text" id="nombreCine" name="nombreCine"><br>
    <label for="direccionCine">Dirección del cine:</label><br>
    <input type="text" id="direccionCine" name="direccionCine"><br>
    <input type="submit" value="Guardar">
</form>*/

//Luego, necesitarás un servlet para manejar la solicitud POST del formulario. Este servlet recogerá los datos del formulario, realizará la operación correspondiente en la base de datos y luego enviará una respuesta al cliente.

iimport java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MiServlet")
public class MiServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASS = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCine = request.getParameter("nombreCine");
        String direccionCine = request.getParameter("direccionCine");

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("INSERT INTO Cines (NombreCine, Direccion) VALUES ('" + nombreCine + "', '" + direccionCine + "')");

            response.getWriter().println("Cine guardado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}