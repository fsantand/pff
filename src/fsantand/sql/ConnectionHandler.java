package fsantand.sql;


import javax.xml.transform.Result;
import java.sql.*;

public class ConnectionHandler {
    private static ConnectionHandler ourInstance = new ConnectionHandler();

    public static ConnectionHandler getInstance() {
        return ourInstance;
    }

    private Connection connection;
    private String database;
    private String username;
    private String password;

    private ConnectionHandler() {
        database = "localhost:5432/pdfFiller";
        username = "pdfappAdmin";
        password = "root";
    }

    public void conectar(){
        boolean estaConectado = false;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Driver no encontrado");
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://"+database,username, password);
            estaConectado = connection.isValid(5000);
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos en "+database);
        }

        System.out.println(estaConectado ? "Conectado exitosamente" : "No se ha conectado");
    }

    public void cerrarConexion(){
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada con exito");
            } catch (SQLException e) {
                System.out.println("No se puede cerrar la conexion.");
            }
        }
    }

    public boolean ingresarSQL(String consultaSQL){
        try {
            if (connection.isClosed()) conectar();
            Statement stmt = connection.createStatement();
            stmt.execute(consultaSQL);
            return true;
        } catch (SQLException e)
        {
            System.out.println("No se pudo acceder a la base de datos. Error "+ e.getErrorCode());
            return false;
        }
    }

    public ResultSet getResultSet(String consultaSQL){
        try {
            if (connection.isClosed()) conectar();
            Statement stmt = connection.createStatement();
            stmt.execute(consultaSQL);
            return stmt.getResultSet();
        } catch (SQLException e)
        {
            System.out.println("No se pudo acceder a la base de datos. Error "+ e.getErrorCode());
            return null;
        }
    }
}
