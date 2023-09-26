package tn.esprit.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.EntiteSI;
import tn.esprit.entities.Fournisseur;
import tn.esprit.repositories.FournisseurRepository;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FournisseurService implements IFournisseurService{
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> retreiveAllFournisseur() {
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        try {
            listFournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
            for(Fournisseur f : listFournisseurs)
            {
              //  u.setUsers(null);
                log.info("Fournisseur = "+f);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listFournisseurs;       }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        try
        {
            fournisseurRepository.save(f);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;
    }


    @Override
    public void deleteFournisseur(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            fournisseurRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        try
        {
            fournisseurRepository.save(f);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;    }

    @Override
    public Fournisseur retrieveFournisseur(long id) {
        Fournisseur f = new Fournisseur();
        try{
            f = fournisseurRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f ;
    }

    @Override
    public List<Fournisseur> searchFournisseur(String keyword) {
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        try {
            listFournisseurs = (List<Fournisseur>) fournisseurRepository.search(keyword);
            for(Fournisseur f : listFournisseurs)
            {
                log.info("Fournisseur = "+f);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listFournisseurs;    }

    @Override
    public Fournisseur findByContrat(long id) {
        return fournisseurRepository.findByContrat(id);
    }

    @Override
    public String findBudget(long id) {


        return  fournisseurRepository.findBudget(id);
    }
    @Override

    public void generateQRCodeImage(String text,int id) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath("/Users/seif/Desktop/pfelast/Front/src/assets/img/QRCode"+String.valueOf(id)+".png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    @Override
    public String toStringg(long id) {
        Fournisseur f = new Fournisseur();
        f=retrieveFournisseur(id);
        return "Supplier \\n Name: "+f.getName()+"\\n Code: "+f.getCode()+"\\n Contact: "+f.getContact()+"\\n Mail:"+f.getMail()+"\\n Website: "+f.getSiteWeb()+"\\n Phone Number: "+f.getTel();
    }

}
