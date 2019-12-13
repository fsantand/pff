import fsantand.pdf.filler.controller.PdfFormFiller;
import fsantand.pdf.filler.model.TestClass;
import fsantand.sql.ConnectionHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Standalone {
    public static void main(String[] args) throws IOException, SQLException {
        //Pruebas
        ConnectionHandler connectionHandler = ConnectionHandler.getInstance();
        String formulario = "C:\\Users\\Trabajo\\Documents\\Portfolio\\formulario_prueba.pdf";
        PdfFormFiller pdf = new PdfFormFiller(formulario);
        List<TestClass> datos = new ArrayList<>();

        connectionHandler.conectar();
        ResultSet rs = connectionHandler.getResultSet("SELECT * FROM form;");

        while(rs.next()){
            datos.add(new TestClass(rs));
        }

        for (TestClass dato: datos) {
            pdf.fillPDF(dato.toFormData());
            pdf.guardarPDF("Printlab", Integer.toString(dato.getId()));
        }

        pdf.cerrarDocumento();
    }
}
