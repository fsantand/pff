# PDF Form Filler
PDF Form Filler (PFF) es una liberia de Java para procesar formularios PDFs de manera programatica desde una base de datos.

Consiste en un *controlador* que se encarga de leer, traspasar y guardar el PDF y una *interfaz*, la cual se aplica a modelos de datos que se quieran traspasar a PDF.

## Uso
1. Crear un usuario y una vista en la base de datos que se quiera acceder. (Por terminos de seguridad)
2. Configurar las credenciales de la base de datos (POR IMPLEMENTAR)
3. Implementar la interfaz *PdfFillable* al modelo de datos a consultar.
4. Crear una instancia de la clase *PdfFormFiller*, entregando la dirección absoluta del PDF a rellenar.
5. Seguir el ejemplo descrito en *Standalone* para ejecutar la libreria.