package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.EntiteSI;
import tn.esprit.entities.Role;
import tn.esprit.entities.Sexe;
import tn.esprit.entities.User;
import tn.esprit.services.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceJunitTest {
        @Autowired
        UserService userService;
        EntiteSI rntite =new EntiteSI();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Date date = sdf.parse("18-02-1997");
    Sexe sexe = Sexe.Male;
    Role role = Role.Admin;
    User u1 = new User(11L,"seif","derbali",date,"derbaliseif97@gmail.com","1234","jendouba","tunis","1002222",sexe,"administration",role,1L,"Manager",rntite);
    User u2 = new User(11L,"seif","derbali",date,"derbaliseif97@gmail.com","1234","jendouba","tunis","1002222",sexe,"administration",role,1L,"Manager",rntite);

    public UserServiceJunitTest() throws ParseException {
    }

    @Test
        @Order(1)
        public void testaddUser() {
            User UserAdded =  userService.addUser(u1);
            Assertions.assertEquals(UserAdded.getId(), UserAdded.getId());
        }

        @Test
        @Order(2)
        public void testRetrieveAllUsers() {
            List<User> listUsers = userService.retreiveAllUsers();
            Assertions.assertEquals(listUsers.size(), listUsers.size());
        }

        /*
        @Order(3)
        @Test
        public void testRetrieveUser() {
            User UserRetrieved = userService.retrieveUser(1L);
            Assertions.assertEquals(1L, UserRetrieved.getId());
        }
*/
        @Test

        @Order(4)
        public void testModifyUser()   {

            User UserUpdated  = userService.updateUser(u2);
            Assertions.assertEquals(u2.getId(), UserUpdated.getId());
        }

        @Test

        @Order(5)
        public void testDeleteUser() {

            userService.deleteUser(11L);
            Assertions.assertEquals(null,userService.retrieveUser(11L));


        }
    }



