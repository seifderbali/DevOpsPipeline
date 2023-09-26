package tn.esprit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.times;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.repositories.ProjetInvestissmentRepository;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class ProjetInvestissementMockTest {
    /*
    @Mock
    ProjetRepository projetInvestissmentRepository;



    @InjectMocks
    ProjetServiceImpl projetService;

    Projet p1 = new Produit(55L, "2365","projet1",50);
    Projet p2 = new Produit(66L, "5681","orojet2",120);
    List<Projet> listProjets = new ArrayList<Projet>() {
        {
            add(p1);
            add(new Projet(90L, "9687","Projet2",30));
            add(new Projet(46L, "4503","Projet3",70));
        }
    };
    @Test
    public void testretrieveAllProjets() {
        Mockito.when(projetRepository.findAll()).thenReturn(listProjets);
        List<Projet> listprojet3 = projetService.retrieveAllProduits();
        assertEquals(3, listprojet3.size());
        System.out.println("2555");
    }
    @Test
    public void testAddFacture() {

        Mockito.when(projetRepository.save(p1)).thenReturn(p1);
        Projet projet1 = projetService.addProjet(p1);
        //assertNotNull(projet1);
        Mockito.verify(projetRepository, times(1)).save(Mockito.any(Projet.class));
        System.out.println("3");
    }
    @Test
    public void testdeleteProjet(){
        projetService.deleteProjet(66L);
        Mockito.verify(projetRepository, times(1)).deleteById(66L);
        System.out.println("4");
    }
    ///sss
    @Test
    public void testupdateProjet(){
        Mockito.when(projetRepository.save(p1)).thenReturn(p1);
        Projet projet1 = projetService.updateProjet(p1);
        Mockito.verify(projetRepository, times(1)).save(Mockito.any(Projet.class));
        System.out.println("5");
    }
    */
}
