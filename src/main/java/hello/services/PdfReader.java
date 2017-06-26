package hello.services;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Meehaeel on 24-Jun-17.
 */
@Component
public class PdfReader{

  public static String PostFile(MultipartFile file) throws IOException {
      //Loading an existing document
      File convFile = new File(file.getOriginalFilename());
      convFile.createNewFile();
      FileOutputStream fos = new FileOutputStream(convFile);
      fos.write(file.getBytes());
      fos.close();
      PDDocument document = PDDocument.load(convFile);

      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();

      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
      System.out.println("The PDF TEXT IS "+text);

      //Closing the document
      document.close();
      return text;
  }
    }
