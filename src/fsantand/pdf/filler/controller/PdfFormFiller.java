package fsantand.pdf.filler.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * Controller to create the PDF
 */
public class PdfFormFiller {
    private PDDocument documento;
    private PDAcroForm formulario;
    private List<PDField> campos;
    /**
     * Constructor
     * @param filepath path to the PDF to fill
     * @see Path
     */
    public PdfFormFiller(String filepath) throws IOException {
        this.documento = PDDocument.load(new File(filepath));
        this.formulario = documento.getDocumentCatalog().getAcroForm();
        this.campos = formulario.getFields();
    }
    /**
     * Fills the pdf with the model's data
     *
     * @param data Model's data for the form
     */
    public void fillPDF(HashMap<String, String> data) throws IOException{
        for (PDField campo: this.campos) {
            campo.setValue(data.get(campo.getFullyQualifiedName()));
        }
    }

    public void guardarPDF(String vista, String distintivo) throws IOException{
        String filename = vista + " - " +LocalDate.now() + "-" + distintivo + ".pdf";
        this.documento.save(filename);
    }

    public void cerrarDocumento() throws IOException{
        this.documento.close();
    }
}
