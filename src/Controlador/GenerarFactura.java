package Controlador;

import Modelo.Venta;
import Modelo.DetalleVenta;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class GenerarFactura {

    public static void emitirDocumentoPdf(Venta venta, String rutaDestino) {
        Document documento = new Document();
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(rutaDestino));
            documento.open();
            
            Font fuenteTitulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font fuenteSubtitulo = new Font(Font.HELVETICA, 12, Font.BOLD);
            Font fuenteNormal = new Font(Font.HELVETICA, 10, Font.NORMAL);
            Font fuenteTablaHeader = new Font(Font.HELVETICA, 10, Font.BOLD);

            // Encabezado con logotipo alineado a la derecha
            PdfPTable tablaEncabezado = new PdfPTable(2);
            tablaEncabezado.setWidthPercentage(100);
            tablaEncabezado.setWidths(new float[]{3.5f, 1.5f});

            PdfPCell celdaTexto = new PdfPCell();
            celdaTexto.setBorder(PdfPCell.NO_BORDER);
            celdaTexto.addElement(new Paragraph("FERRETERÍA MARROQUÍN", fuenteTitulo));
            celdaTexto.addElement(new Paragraph("Venta de Materiales de Construcción y Herramientas", fuenteNormal));
            celdaTexto.addElement(new Paragraph("Guatemala", fuenteNormal));
            tablaEncabezado.addCell(celdaTexto);

            PdfPCell celdaLogo = new PdfPCell();
            celdaLogo.setBorder(PdfPCell.NO_BORDER);
            celdaLogo.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            
            try {
                URL urlLogo = GenerarFactura.class.getResource("/Imagenes/logo_ferre.png");
                if (urlLogo != null) {
                    Image logo = Image.getInstance(urlLogo);
                    logo.scaleToFit(110, 60);
                    logo.setAlignment(Image.ALIGN_RIGHT);
                    celdaLogo.addElement(logo);
                }
            } catch (Exception imgEx) {
                System.out.println("No se pudo cargar el logo en la factura: " + imgEx.getMessage());
            }
            tablaEncabezado.addCell(celdaLogo);
            
            documento.add(tablaEncabezado);
            documento.add(new Paragraph("------------------------------------------------------------------------------------------"));
            
            documento.add(new Paragraph("COMPROBANTE DE VENTA (FACTURA)", fuenteSubtitulo));
            documento.add(new Paragraph("Fecha de Emisión: " + venta.getFecha(), fuenteNormal));
            documento.add(new Paragraph("Tipo de Operación: " + venta.getTipoComprobante(), fuenteNormal));
            documento.add(new Paragraph(" ")); 

            // --- TABLA REAJUSTADA A 6 COLUMNAS ---
            PdfPTable tabla = new PdfPTable(6);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{2.2f, 1.3f, 0.9f, 1.1f, 0.9f, 1.2f}); // Proporciones de espacio

            String[] headers = {"Descripción / Tipo", "Marca", "Unidad", "Precio C/U", "Cant.", "Subtotal"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, fuenteTablaHeader));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                tabla.addCell(cell);
            }

            for (DetalleVenta dv : venta.getDetalles()) {
                tabla.addCell(new Phrase(dv.getProducto().getTipo(), fuenteNormal));
                tabla.addCell(new Phrase(dv.getProducto().getMarca(), fuenteNormal));
                tabla.addCell(new Phrase(dv.getProducto().getUnidad(), fuenteNormal));
                
                PdfPCell cellPrecio = new PdfPCell(new Phrase("Q " + String.format("%.2f", dv.getProducto().getPrecio()), fuenteNormal));
                cellPrecio.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                tabla.addCell(cellPrecio);
                
                // Celda de Cantidad
                PdfPCell cellCantidad = new PdfPCell(new Phrase(String.valueOf(dv.getCantidad()), fuenteNormal));
                cellCantidad.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                tabla.addCell(cellCantidad);
                
                PdfPCell cellSubtotal = new PdfPCell(new Phrase("Q " + String.format("%.2f", dv.getSubtotal()), fuenteNormal));
                cellSubtotal.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                tabla.addCell(cellSubtotal);
            }

            documento.add(tabla);
            documento.add(new Paragraph(" "));

            Paragraph totalParagraph = new Paragraph("MONTO TOTAL A PAGAR: Q " + String.format("%.2f", venta.getTotal()), fuenteSubtitulo);
            totalParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
            documento.add(totalParagraph);
            
            documento.add(new Paragraph(" "));
            Paragraph gracias = new Paragraph("¡Gracias por su preferencia!", fuenteNormal);
            gracias.setAlignment(Paragraph.ALIGN_CENTER);
            documento.add(gracias);

        } catch (DocumentException | IOException e) {
            System.out.println("Error crítico al generar el PDF de la Factura: " + e.getMessage());
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }
}