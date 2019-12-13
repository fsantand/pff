package fsantand.pdf.filler.model;

import java.util.HashMap;
/**
 * Interface that standardizes processing data from a model to PDF Form
 *
*/
public interface PdfFillable {
    /**
    * @return A hash map with the property-value pair for the PDF form
    * */
    HashMap<String, String> toFormData();
}
