package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.DateValidation;
import tn.esprit.entities.Facture;
import tn.esprit.repositories.DateValidationRepository;
import tn.esprit.repositories.FactureRepositry;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FactureService implements IFactureService{
    @Autowired
    FactureRepositry factureRepositry;

    @Override
    public List<Facture> retreiveAllFacture() {
        List<Facture> listFactures = new ArrayList<Facture>();
        try {
            listFactures = (List<Facture>) factureRepositry.findAll();
            for(Facture d : listFactures)
            {
                //c.setUsers(null);
                log.info("DateValidation = "+d);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listFactures;          }

    @Override
    public Facture addFacture(Facture f) {
        try
        {
            factureRepositry.save(f);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;
    }

    @Override
    public void deleteFacture(long id) {

        try{
            //	Long idl = Long.parseLong(id);
            factureRepositry.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public Facture updateFacture(Facture f) {
        try
        {
            factureRepositry.save(f);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;
    }

    @Override
    public Facture retrieveFacture(long id) {
        Facture f = new Facture();
        try{
            f = factureRepositry.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;
    }
}
