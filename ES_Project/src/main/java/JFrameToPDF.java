import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class JFrameToPDF {

	public static void JFrameToPDF() throws IOException, DocumentException {

		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.setBackground(Color.PINK);
		BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D graph2d = image.createGraphics();
		frame.printAll(graph2d);
		graph2d.dispose();
		ImageIO.write(image, "png", new File("calendarImage.png"));
		Document pdfDocument1 = new Document(PageSize.A4.rotate(), 0, frame.getHeight(), 0, frame.getWidth());
		PdfWriter.getInstance(pdfDocument1, new FileOutputStream("HelloPdf.pdf"));
		pdfDocument1.open();
		pdfDocument1.add(com.itextpdf.text.Image.getInstance("calendarImage.png"));
		pdfDocument1.close();
		// System.out.print("Pdf com imagem gerado");
	}
}