package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.swear_words;
import tn.esprit.repositories.SwearRepository;


@Service
public class SwearService {
    @Autowired
    SwearRepository swearReposiory;

    public List<swear_words> retreiveAllswears() {
        List<swear_words> listSwears = new ArrayList<swear_words>();
        try {
            listSwears = (List<swear_words>) swearReposiory.findAll();
            for(swear_words f : listSwears)
            {
                System.out.println("user = "+f);
            }}
        catch(Exception e)
        {
            System.out.println("error = "+e);
        }

        return listSwears;
    }

    public swear_words addSwears(swear_words f) {
        try
        {
            swearReposiory.save(f);
        }
        catch(Exception e)
        {
            System.out.println("error = "+e);
        }
        return f;
    }


    public void deleteSwear(long id) {

        try{
            swearReposiory.deleteById(id);
        }
        catch(Exception e)
        {
            System.out.println("error = "+e);
        }

    }


    public List<swear_words> listswears() {
        List<swear_words> listSwears = new ArrayList<swear_words>();

        listSwears = (List<swear_words>) swearReposiory.findAll();

        return listSwears;
    }

    public int swearAction(String ch) {
        List<String> swearList = swearReposiory.listSwear();
        int i=0;

        while(i < swearList.size() ){

            if (ch.contains((swearList.get(i)))==true){
                return 1;
            }
            i++;
        }

        return 0;
    }

}