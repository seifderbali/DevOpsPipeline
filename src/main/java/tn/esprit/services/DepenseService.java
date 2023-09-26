package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.ComiteTechnique;
import tn.esprit.entities.Depense;
import tn.esprit.repositories.DepenseRepositry;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DepenseService implements IDepenseService{
    @Autowired
    DepenseRepositry depenseRepositry;

    @Override
    public List<Depense> retreiveAllDepense() {
        List<Depense> listDepenses = new ArrayList<Depense>();
        try {
            listDepenses = (List<Depense>) depenseRepositry.findAll();
            for(Depense c : listDepenses)
            {
                //c.setUsers(null);
                log.info("Depense = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listDepenses;        }

    @Override
    public Depense addDepense(Depense d) {
        try
        {
            depenseRepositry.save(d);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return d;
    }

    @Override
    public void deleteDepense(long id) {

        try{
            //	Long idl = Long.parseLong(id);
            depenseRepositry.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }


    @Override
    public Depense updateDepense(Depense c) {
        try
        {
            depenseRepositry.save(c);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c;    }

    @Override
    public Depense retrieveDepense(long id) {
        Depense d = new Depense();
        try{
            d = depenseRepositry.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return d;
    }

    @Override
    public List<Depense> searchDepense(String keyword) {
        List<Depense> listDepenses = new ArrayList<Depense>();
        try {
            listDepenses = (List<Depense>) depenseRepositry.search(keyword);
            for(Depense d : listDepenses)
            {
                log.info("EntiteSI = "+d);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listDepenses;
    }
}
