package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.ProjetInvestissment;
import tn.esprit.repositories.ProjetInvestissmentRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProjetInvestissmentService implements IProjetInvestissmentService{
    @Autowired
    ProjetInvestissmentRepository projetInvestissmentRepository;

    @Override
    public List<ProjetInvestissment> retreiveAllProjetInvestissment() {
        List<ProjetInvestissment> listProjetInvestissments = new ArrayList<ProjetInvestissment>();
        try {
            listProjetInvestissments = (List<ProjetInvestissment>) projetInvestissmentRepository.findAll();
            for(ProjetInvestissment p : listProjetInvestissments)
            {
                //  u.setUsers(null);
                log.info("ProjetInvestissment = "+p);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listProjetInvestissments;    }

    @Override
    public ProjetInvestissment addProjetInvestissmentr(ProjetInvestissment p) {
        try
        {
            projetInvestissmentRepository.save(p);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return p;    }

    @Override
    public void deleteProjetInvestissment(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            projetInvestissmentRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public ProjetInvestissment updateProjetInvestissment(ProjetInvestissment p) {
        try
        {
            projetInvestissmentRepository.save(p);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return p;
    }

    @Override
    public ProjetInvestissment retrieveProjetInvestissment(long id) {
        ProjetInvestissment p = new ProjetInvestissment();
        try{
            p = projetInvestissmentRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return p ;    }

    @Override
    public List<ProjetInvestissment> searchProjetInvestissment(String keyword) {
        List<ProjetInvestissment> listProjetInvestissments = new ArrayList<ProjetInvestissment>();
        try {
            listProjetInvestissments = (List<ProjetInvestissment>) projetInvestissmentRepository.search(keyword);
            for(ProjetInvestissment p : listProjetInvestissments)
            {
                log.info("ProjetInvestissment = "+p);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listProjetInvestissments;        }
    /*
        @Override
        public BudgetInvestissement findBudget(long id) {
            return projetInvestissmentRepository.findBudget(id);
        }

        @Override
        public List<BudgetInvestissement> findByEntite(long id) {
            List<ProjetInvestissment> listProjetInvestissments = new ArrayList<ProjetInvestissment>();
            List<BudgetInvestissement> listBudgetInvestissements = new ArrayList<BudgetInvestissement>();

            listProjetInvestissments = (List<ProjetInvestissment>) projetInvestissmentRepository.findAll();
            for(ProjetInvestissment p : listProjetInvestissments)
            {
                if (p.getEntiteSI().getId() == id){
                    listBudgetInvestissements.add(p.getBudgetInvestissement());
                }

            }
            return listBudgetInvestissements;
        }


     */
    @Override
    public ProjetInvestissment findProject(long id) {
        return projetInvestissmentRepository.findProjectInvesst(id);    }

}
