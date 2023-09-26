package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.ComiteTechnique;
import tn.esprit.repositories.ComiteTechniqueRepositry;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ComiteTechniqueService implements IComiteTechniqueService{

    @Autowired
    ComiteTechniqueRepositry comiteTechniqueRepositry;

    @Override
    public List<ComiteTechnique> retreiveAllComiteTechnique() {
        List<ComiteTechnique> listComiteTechniques = new ArrayList<ComiteTechnique>();
        try {
            listComiteTechniques = (List<ComiteTechnique>) comiteTechniqueRepositry.findAll();
            for(ComiteTechnique c : listComiteTechniques)
            {
                //c.setUsers(null);
                log.info("ComiteTechnique = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listComiteTechniques;        }

    @Override
    public List<ComiteTechnique> retreiveAllComiteTechniqueInv() {
        List<ComiteTechnique> listComiteTechniques = new ArrayList<ComiteTechnique>();
        try {
            listComiteTechniques = (List<ComiteTechnique>) comiteTechniqueRepositry.findAllInv();
            for(ComiteTechnique c : listComiteTechniques)
            {
                //c.setUsers(null);
                log.info("ComiteTechnique = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listComiteTechniques;        }

    @Override
    public List<ComiteTechnique> retreiveAllComiteTechniqueMain() {
        List<ComiteTechnique> listComiteTechniques = new ArrayList<ComiteTechnique>();
        try {
            listComiteTechniques = (List<ComiteTechnique>) comiteTechniqueRepositry.findAllMain();
            for(ComiteTechnique c : listComiteTechniques)
            {
                //c.setUsers(null);
                log.info("ComiteTechnique = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listComiteTechniques;        }

    @Override
    public ComiteTechnique addComiteTechnique(ComiteTechnique c) {
        try
        {
            comiteTechniqueRepositry.save(c);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c;
    }

    @Override
    public void deleteComiteTechnique(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            comiteTechniqueRepositry.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public ComiteTechnique updateComiteTechnique(ComiteTechnique c) {
        try
        {
            comiteTechniqueRepositry.save(c);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c;
    }

    @Override
    public ComiteTechnique retrieveComiteTechnique(long id) {
        ComiteTechnique c = new ComiteTechnique();
        try{
             c = comiteTechniqueRepositry.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c;
    }

    @Override
    public List<ComiteTechnique> searchComiteTechnique(String keyword) {
        List<ComiteTechnique> listComiteTechniques = new ArrayList<ComiteTechnique>();
        try {
            listComiteTechniques = (List<ComiteTechnique>) comiteTechniqueRepositry.search(keyword);
            for(ComiteTechnique c : listComiteTechniques)
            {
                log.info("EntiteSI = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listComiteTechniques;
    }

    @Override
    public List<ComiteTechnique> searchComiteTechniqueInv(String keyword) {
        List<ComiteTechnique> listComiteTechniques = new ArrayList<ComiteTechnique>();
        try {
            listComiteTechniques = (List<ComiteTechnique>) comiteTechniqueRepositry.searchInv(keyword);
            for(ComiteTechnique c : listComiteTechniques)
            {
                log.info("EntiteSI = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listComiteTechniques;
    }

    @Override
    public List<ComiteTechnique> searchComiteTechniqueMain(String keyword) {
        List<ComiteTechnique> listComiteTechniques = new ArrayList<ComiteTechnique>();
        try {
            listComiteTechniques = (List<ComiteTechnique>) comiteTechniqueRepositry.searchMain(keyword);
            for(ComiteTechnique c : listComiteTechniques)
            {
                log.info("EntiteSI = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listComiteTechniques;
    }
}
