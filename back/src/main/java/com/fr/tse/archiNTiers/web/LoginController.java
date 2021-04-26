package com.fr.tse.archiNTiers.web;

import com.fr.tse.archiNTiers.business.Utilisateur;
import com.fr.tse.archiNTiers.errors.ResourceNotFoundException;
import com.fr.tse.archiNTiers.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping(method = RequestMethod.POST, path = "/connexion")
        public Utilisateur connect(@RequestBody Map<String,String> json) throws ResourceNotFoundException {
            String login = json.get("login");
            String motDePasse = json.get("motDePasse");
            Utilisateur utilisateurConnecte = loginService.connexion(login,motDePasse);

        if (utilisateurConnecte != null) {
            return utilisateurConnecte;
        } else {
            throw new ResourceNotFoundException("Cet utilisateur n'existe pas.");
        }
    }
}
