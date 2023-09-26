package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.ComiteTechnique;
import tn.esprit.entities.DateValidation;
import tn.esprit.repositories.DateValidationRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DateValidationService implements IDateValidationService {

    @Autowired
    DateValidationRepository dateValidationRepository;

    @Override
    public List<DateValidation> retreiveAllDateValidation() {
        List<DateValidation> listDateValidations = new ArrayList<DateValidation>();
        try {
            listDateValidations = (List<DateValidation>) dateValidationRepository.findAll();
            for(DateValidation d : listDateValidations)
            {
                //c.setUsers(null);
                log.info("DateValidation = "+d);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listDateValidations;       }

    @Override
    public DateValidation addDateValidation(DateValidation d) {
        try
        {
            dateValidationRepository.save(d);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return d;    }

    @Override
    public void deleteDateValidation(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            dateValidationRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public DateValidation updateValidation(DateValidation d) {
        try
        {
            dateValidationRepository.save(d);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return d;    }

    @Override
    public DateValidation retrieveValidation(long id) {
        DateValidation d = new DateValidation();
        try{
            d = dateValidationRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return d;    }
}
