package tn.esprit.controllers;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Depense;
import tn.esprit.services.IContatDeMarcheService;
import tn.esprit.services.IDepenseService;
import tn.esprit.services.IFactureService;

import java.util.List;

@RestController
@RequestMapping("/Depense")
@CrossOrigin(origins = {"*","http://localhost:4200/"})
public class DepenseController {

    @Autowired
    IDepenseService Ds;
    @Autowired
    IFactureService Fs;
    @Autowired
    IContatDeMarcheService Cs;


    @PostMapping("/addDepense/{idf}/{idc}")
    void add(@RequestBody Depense d, @PathVariable("idf") int idf, @PathVariable("idc") int idc)
    {
        d.setFacture(Fs.retrieveFacture(idf));
        d.setContrat(Cs.retrieveContatDeMarche(idc));
        Ds.addDepense(d);
    }

    @PutMapping("/updateDepense")
    void update(@RequestBody Depense d)
    {
        Ds.updateDepense(d);
    }

    @DeleteMapping("/deleteDepense/{id}")
    void delete(@PathVariable("id") int id)
    {
        Ds.deleteDepense(id);
    }
    @GetMapping("/displayDepense")
    List<Depense> display()
    {
        return Ds.retreiveAllDepense();
    }

    @GetMapping("/find/{id}")
    Depense find(@PathVariable("id") int id)
    {
        return Ds.retrieveDepense(id);
    }

    @GetMapping("/search/{keyword}")
    List<Depense> search(@PathVariable("keyword") String keyword)
    {
        return Ds.searchDepense(keyword);
    }



    //STAGE PDF
    @GetMapping("/genFacture/{fileName}")
    HttpEntity<byte[]> createPdfStage(@PathVariable("fileName") String fileName) throws IOException, BadElementException {
        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine();
        /* next, get the Template */
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class",
                ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate("templates/Stage.vm");
        /* create a context and add data */
        VelocityContext context = new VelocityContext();
        context.put("name","seif");
        context.put("niveau","NiveauCourantEt");
        context.put("cycle","getCycleEt");
        context.put("genDateTime", LocalDateTime.now().toString());
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
        System.out.println(writer.toString());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos = generatePdf(writer.toString());
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + fileName.replace(" ", "_"));
        header.setContentLength(baos.toByteArray().length);
        return new HttpEntity<byte[]>(baos.toByteArray(), header);
    }
    public ByteArrayOutputStream generatePdf(String html) throws BadElementException, IOException {


        PdfWriter pdfWriter = null;
        String TARGET = "";





        // create a new document
        Document document = new Document();
        try {

            document = new Document();
            // document header attributes

            document.addAuthor("Biat");
            document.addCreationDate();
            document.addProducer();
            document.addCreator("Biat");







            //document.addTitle("HTML to PDF using itext");
            document.setPageSize(PageSize.A4);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            // open document
            document.open();
            int indentation = 0;
            String filename = "src/main/resources/templates/images/backgound.png";
            Image image = Image.getInstance(filename);
            image.scaleAbsolute(PageSize.A4);

            image.setAbsolutePosition(0,0);
            document.add(image);

            XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
            xmlWorkerHelper.getDefaultCssResolver(true);
            xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(
                    html));


            // close the document


            document.close();
            System.out.println("PDF generated successfully");

            return baos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
