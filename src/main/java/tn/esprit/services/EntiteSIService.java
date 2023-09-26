package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.EntiteSI;
import tn.esprit.entities.User;
import tn.esprit.repositories.EntiteSIRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EntiteSIService implements IEntiteSIService{

    @Autowired
    EntiteSIRepository entiteSIRepository;

    @Override
    public List<EntiteSI> retreiveAllEntiteSI() {
        List<EntiteSI> listEntiteSIs = new ArrayList<EntiteSI>();
        try {
            listEntiteSIs = (List<EntiteSI>) entiteSIRepository.findAll();
            for(EntiteSI u : listEntiteSIs)
            {
                //u.setUsers(null);
                log.info("user = "+u);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listEntiteSIs;    }

    @Override
    public EntiteSI addEntiteSI(EntiteSI u) {
        try
        {
            entiteSIRepository.save(u);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u;
    }

    @Override
    public void deleteEntiteSI(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            entiteSIRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public EntiteSI updateEntiteSI(EntiteSI u) {
        try
        {
            entiteSIRepository.save(u);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u;
    }

    @Override
    public EntiteSI retrieveEntiteSI(long id) {
        EntiteSI u = new EntiteSI();
        try{
            u = entiteSIRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u ;
    }

    @Override
    public List<EntiteSI> searchEntiteSI(String keyword) {
        List<EntiteSI> listEntiteSIs = new ArrayList<EntiteSI>();
        try {
            listEntiteSIs = (List<EntiteSI>) entiteSIRepository.search(keyword);
            for(EntiteSI u : listEntiteSIs)
            {
                log.info("EntiteSI = "+u);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listEntiteSIs;
    }

    @Override
    public EntiteSI findByName(String name) {
        EntiteSI u = new EntiteSI();
        try{
            u = entiteSIRepository.finfByName(name);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return u ;
    }

    @Override
    public String findBudget(long id) {
        return entiteSIRepository.findBudget(id);
    }

    @Override
    public String allbudget() {
        return entiteSIRepository.allbudget();
    }
}
