package tn.esprit.services;


import tn.esprit.entities.DateValidation;

import java.util.List;

public interface IDateValidationService {
    List<DateValidation> retreiveAllDateValidation();
    DateValidation addDateValidation(DateValidation d);
    void deleteDateValidation(long id);
    DateValidation updateValidation(DateValidation d);
    DateValidation retrieveValidation(long id);
}
