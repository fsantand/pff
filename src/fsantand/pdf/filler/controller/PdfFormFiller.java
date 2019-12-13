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
    private PDDocument document;
    private PDAcroForm form;
    private List<PDField> fields;
    /**
     * Constructor
     * @param filepath path to the PDF to fill
     * @see Path
     */
    public PdfFormFiller(String filepath) throws IOException {
        this.document = PDDocument.load(new File(filepath));
        this.form = document.getDocumentCatalog().getAcroForm();
        this.fields = form.getFields();
    }
    /**
     * Fills the pdf with the model's data
     *
     * @param data Model's data for the form
     */
    public void fillPDF(HashMap<String, String> data) throws IOException{
        for (PDField campo: this.fields) {
            campo.setValue(data.get(campo.getFullyQualifiedName()));
        }
    }

    public void savePDF(String view, String distinctive) throws IOException{
        String filename = view + " - " +LocalDate.now() + "-" + distinctive+ ".pdf";
        this.document.save(filename);
    }

    public void closeDocument() throws IOException{
        this.document.close();
    }
}
