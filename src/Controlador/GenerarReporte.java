package Controlador;

import Modelo.Venta;
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
import java.util.ArrayList;

public class GenerarReporte {

    public static void emitirReporteCierrePdf(ArrayList<Venta> ventasFiltradas, String lapsoTiempo, String rutaDestino) {
        Document documento = new Document();
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(rutaDestino));
            documento.open();
            
            Font fuenteTitulo = new Font(Font.HELVETICA, 16, Font.BOLD);
            Font fuenteSubtitulo = new Font(Font.HELVETICA, 12, Font.BOLD);
            Font fuenteNormal = new Font(Font.HELVETICA, 10, Font.NORMAL);
            Font fuenteTablaHeader = new Font(Font.HELVETICA, 10, Font.BOLD);
            
            PdfPTable tablaEncabezado = new PdfPTable(2);
            tablaEncabezado.setWidthPercentage(100);
            tablaEncabezado.setWidths(new float[]{3.5f, 1.5f});

            // Lado Izquierdo: Identidad del negocio
            PdfPCell celdaTexto = new PdfPCell();
            celdaTexto.setBorder(PdfPCell.NO_BORDER);
            celdaTexto.addElement(new Paragraph("FERRETERÍA MARROQUÍN", fuenteTitulo));
            celdaTexto.addElement(new Paragraph("Auditoría y Balance de Cierre de Caja", fuenteNormal));
            celdaTexto.addElement(new Paragraph("Guatemala", fuenteNormal));
            tablaEncabezado.addCell(celdaTexto);

            // Lado Derecho: Logotipo
            PdfPCell celdaLogo = new PdfPCell();
            celdaLogo.setBorder(PdfPCell.NO_BORDER);
            celdaLogo.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            
            try {
                URL urlLogo = GenerarReporte.class.getResource("/Imagenes/logo_ferre.png");
                if (urlLogo != null) {
                    Image logo = Image.getInstance(urlLogo);
                    logo.scaleToFit(110, 60);
                    logo.setAlignment(Image.ALIGN_RIGHT);
                    celdaLogo.addElement(logo);
                }
            } catch (Exception imgEx) {
                System.out.println("No se pudo inyectar el logo en el reporte: " + imgEx.getMessage());
            }
            tablaEncabezado.addCell(celdaLogo);
            
            documento.add(tablaEncabezado);
            documento.add(new Paragraph("------------------------------------------------------------------------------------------"));
            
            // Información del Periodo Consultado
            documento.add(new Paragraph("REPORTE DE AUDITORÍA INVENTARIO Y VENTAS", fuenteSubtitulo));
            documento.add(new Paragraph("Periodo Evaluado: " + lapsoTiempo, fuenteNormal));
            documento.add(new Paragraph(" ")); 

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{1.5f, 2.5f, 2.0f, 1.5f});

            String[] headers = {"No. Factura", "Fecha / Hora", "Tipo Comprobante", "Monto Cobrado"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, fuenteTablaHeader));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                tabla.addCell(cell);
            }

            double acumuladoTotal = 0.0;
            int conteoVentas = 0;

            // Poblar las filas con los datos rescatados
            if (ventasFiltradas != null && !ventasFiltradas.isEmpty()) {
                for (Venta v : ventasFiltradas) {
                    tabla.addCell(new Phrase("FAC-" + v.getIdVenta(), fuenteNormal));
                    tabla.addCell(new Phrase(v.getFecha(), fuenteNormal));
                    tabla.addCell(new Phrase(v.getTipoComprobante(), fuenteNormal));
                    
                    PdfPCell cellMonto = new PdfPCell(new Phrase("Q " + String.format("%.2f", v.getTotal()), fuenteNormal));
                    cellMonto.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
                    tabla.addCell(cellMonto);
                    
                    acumuladoTotal += v.getTotal();
                    conteoVentas++;
                }
            }

            documento.add(tabla);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("------------------------------------------------------------------------------------------"));

            documento.add(new Paragraph("RESUMEN DE CONCILIACIÓN:", fuenteSubtitulo));
            documento.add(new Paragraph("Cantidad de Facturas Emitidas: " + conteoVentas, fuenteNormal));
            
            Paragraph totalParagraph = new Paragraph("EFECTIVO TOTAL EN CAJA: Q " + String.format("%.2f", acumuladoTotal), fuenteSubtitulo);
            totalParagraph.setAlignment(Paragraph.ALIGN_LEFT);
            documento.add(totalParagraph);
            
            documento.add(new Paragraph(" "));
            Paragraph firma = new Paragraph("Firma del Auditor / Administrador", fuenteNormal);
            firma.setAlignment(Paragraph.ALIGN_CENTER);
            documento.add(firma);

        } catch (DocumentException | IOException e) {
            System.out.println("Error crítico al generar el PDF del Reporte: " + e.getMessage());
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }
}