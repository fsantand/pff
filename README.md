# PDF Form Filler

#### Table of Contents
* [English](#English)
    * [Usage](#Usage) 
* [Spanish](#Spanish)
    * [Uso](#Uso)

## English
PDF Form Filler (PFF) is a Java library that consists on a
programatically way to process PDF formularies, fetching data from a
database. 

It contains a *controller* that has the function to read, load data and
save the PDF, and an *interface*, the which you apply to a data model
you want to send to a PDF.

### Usage
1. Create a user and a view of the data you want to load to a PDF
(For security reasons)
2. Configure the credentials of the user in the library (**TODO**)
3. Implement the interface *PdfFillable* to the data model.
4. Create an instsance of the class *PdfFormFiller*, passing the path of
the PDF to fill.
5. Use the instance methods to manipulate the data.

There's an example in the class ***Standalone*** of the usage of the}
library

## Spanish
PDF Form Filler (PFF) es una liberia de Java para procesar formularios
PDFs de manera programatica desde una base de datos.

Consiste en un *controlador* que se encarga de leer, traspasar y guardar
el PDF y una *interfaz*, la cual se aplica a modelos de datos que se
quieran traspasar a PDF.

### Uso
1. Crear un usuario y una vista en la base de datos que se quiera acceder. (Por terminos de seguridad)
2. Configurar las credenciales de la base de datos (POR IMPLEMENTAR)
3. Implementar la interfaz *PdfFillable* al modelo de datos a consultar.
4. Crear una instancia de la clase *PdfFormFiller*, entregando la dirección absoluta del PDF a rellenar.
5. Utilizar los metodos de la instancia para manipular los datos.

En la clase ***Standalone*** hay un ejemplo del uso de la libreria.