package fsantand.pdf.filler.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Just a bean test class
 */
public class TestClass implements PdfFillable {
    private int id;
    private String nombre;
    private long cantidad;
    private LocalDate fechaEntrega;

    public TestClass(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.nombre = rs.getString("nombre");
        this.cantidad = rs.getLong("cantidad");
        this.fechaEntrega = rs.getDate("fecha_entrega").toLocalDate();
    }

    public int getId() {
        return id;
    }

    @Override
    public HashMap<String, String> toFormData(){
        HashMap<String, String> data = new HashMap<>();
        data.put("id", Integer.toString(this.id));
        data.put("nombre", this.nombre);
        data.put("cantidad", Long.toString(this.cantidad));
        data.put("fecha_entrega", this.fechaEntrega.toString());
        return data;
    }
}
