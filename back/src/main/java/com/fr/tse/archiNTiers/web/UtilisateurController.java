package com.fr.tse.archiNTiers.web;

import com.fr.tse.archiNTiers.business.Utilisateur;
import com.fr.tse.archiNTiers.errors.ResourceNotFoundException;
import com.fr.tse.archiNTiers.service.impl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    UtilisateurServiceImpl utilisateurService;

    @RequestMapping(method = RequestMethod.POST, path = "/creerUtilisateur")
    Utilisateur creerUtilisateur(@RequestBody Map<String,String> json){
        String nom = json.get("nom");
        String prenom = json.get("prenom");
        String promotion = json.get("promotion");
        String motDePasse = json.get("motDePasse");

        return utilisateurService.creerUtilisateur(nom, prenom, promotion, motDePasse);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllUtilisateurs")
    List<Utilisateur> getAllUtilisateurs(){

        return utilisateurService.getAllUtilisateurs();

    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUtilisateur")
    Utilisateur getUtilisateur(@RequestParam Map<String,String> json) throws ResourceNotFoundException {
        Long idUtilisateur = Long.parseLong(json.get("idUtilisateur"));

        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUtilisateur);
        if(utilisateur != null){
            return utilisateur;
        }else{
            throw new ResourceNotFoundException("Cet utilisateur n'existe pas.");
        }
    }
}
