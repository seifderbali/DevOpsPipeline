package tn.esprit.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.LoginRequest;
import tn.esprit.entities.User;
import tn.esprit.services.IEntiteSIService;
import tn.esprit.services.IUserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = {"*","http://localhost:4200/"})
public class UserController {

    @Autowired
    IUserService Us;
    @Autowired

    IEntiteSIService Es;

    @PostMapping("/adduser/{id}")
    void add(@RequestBody User u,@PathVariable("id") long id)
    {
        u.setEntiteSI(Es.retrieveEntiteSI(id));
            Us.addUser(u);
    }

    @PutMapping("/updateuser/{id}")
    void update(@RequestBody User u,@PathVariable("id") long id)
    {
        u.setEntiteSI(Es.retrieveEntiteSI(id));
        Us.updateUser(u);
    }
    @DeleteMapping("/deleteuser/{id}")
    void delete(@PathVariable("id") long id)
    {
        Us.deleteUser(id);
    }
    @GetMapping("/displayusers")
    List<User> display()
    {
        return Us.retreiveAllUsers();
    }
    @GetMapping("/find/{id}")
    User find(@PathVariable("id") long id)
    {
        return Us.retrieveUser(id);
    }

    @GetMapping("/search/{keyword}")
    List<User> search(@PathVariable("keyword") String keyword)
    {
        return Us.searchUser(keyword);
    }
    @GetMapping("/getrole/{id}")
    String getrole(@PathVariable("id") long id)
    {
        return Us.retrieveUserRole(id);
    }





    @RequestMapping(value = "/doLogin", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public User DoLogin(@RequestBody LoginRequest er) {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@");
        User e = Us.DoLogin(er.getMail(), er.getPassword());
        if (e != null && e.getToken()==null) {
            //String token = getJWTToken(er.getPassword());
            e.setToken(e.getId()+"Bearer"+e.getRole().toString());
        }
        return e;
    }
    @GetMapping("/recover/{mail}")
    void recver(@PathVariable("mail") String mail)
    {
        Us.recover(mail);
    }

    @PostMapping("/meet/{name}")
    void meet(@RequestBody String[] mails,@PathVariable("name") String name)
    {
        Us.sendMeet(mails, name);
    }

    /*
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setId("softtekJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 900000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
    */
}
