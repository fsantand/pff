package fsantand.sql;

import java.sql.*;

/**
 * Class that handles all the connections to the database.
 * Implemented on PostgreSQL
 */
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
    }

    /**
     * Set the credentials for accessing the database
     *
     * @param databaseURL The database location (Path or URL)
     * @param username Database's username
     * @param password Database user's password.
     */
    public void setCredentials(String databaseURL, String username, String password){
        this.database = databaseURL;
        this.username = username;
        this.password = password;
    }

    public void connect(){
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

    public void closeConection(){
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada con exito");
            } catch (SQLException e) {
                System.out.println("No se puede cerrar la conexion.");
            }
        }
    }

    /**
     * Method that handles the data needed for the PdfFormFiller
     * @param sqlQuery Query to the database
     * @return A ResultSet with all the data
     */
    public ResultSet getResultSet(String sqlQuery){
        try {
            if (connection.isClosed()) connect();
            Statement stmt = connection.createStatement();
            stmt.execute(sqlQuery);
            return stmt.getResultSet();
        } catch (SQLException e)
        {
            System.out.println("No se pudo acceder a la base de datos. Error "+ e.getErrorCode());
            return null;
        }
    }
}
