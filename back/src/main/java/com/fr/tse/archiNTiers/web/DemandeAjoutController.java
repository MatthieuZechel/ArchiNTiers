package com.fr.tse.archiNTiers.web;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Mobilite;
import com.fr.tse.archiNTiers.business.Utilisateur;
import com.fr.tse.archiNTiers.errors.ResourceNotFoundException;
import com.fr.tse.archiNTiers.service.impl.DemandeAjoutServiceImpl;
import com.fr.tse.archiNTiers.service.impl.MobiliteServiceImpl;
import com.fr.tse.archiNTiers.service.impl.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DemandeAjoutController {

    @Autowired
    DemandeAjoutServiceImpl demandeAjoutService;

    @Autowired
    UtilisateurServiceImpl utilisateurService;

    @Autowired
    MobiliteServiceImpl mobiliteService;


    @RequestMapping(method = RequestMethod.POST, path = "/creerDemandeAjout")
    DemandeAjout creerDemandeAjout(@RequestBody Map<String,String> json){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Long idUtilisateur = Long.parseLong(json.get("idUtilisateur"));
        String ville = json.get("ville");
        String pays = json.get("pays");
        LocalDate dateDebut = LocalDate.parse(json.get("dateDebut"),formatter);
        LocalDate dateFin = LocalDate.parse(json.get("dateFin"),formatter);

        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUtilisateur);

        return demandeAjoutService.creerDemandeAjout(utilisateur, ville, pays, dateDebut, dateFin);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/getDemandeAjout")
    DemandeAjout getDemandeAjout(@RequestParam Map<String,String> json) throws ResourceNotFoundException {
        Long idDemandeAjout = Long.parseLong(json.get("idDemandeAjout"));

        DemandeAjout demandeAjout = demandeAjoutService.getDemandeAjout(idDemandeAjout);
        if(demandeAjout != null){
            return demandeAjout;
        }else{
            throw new ResourceNotFoundException("La demande n°"+ idDemandeAjout +" n'existe pas.");
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getUtilisateurAllDemandes")
    List<DemandeAjout> getUtilisateurAllDemandes(Long idUtilisateur) throws ResourceNotFoundException {

        List<DemandeAjout> demandeAjouts = demandeAjoutService.getUtilisateurAllDemandeAjout(idUtilisateur);
        if(demandeAjouts == null) {
            throw new ResourceNotFoundException("L'utilisateur n°"+ idUtilisateur +" n'existe pas.");
        }
        if(demandeAjouts.isEmpty()){
            throw new ResourceNotFoundException("Cet utilisateur n'a pas encore fait de demandes.");
        }
        return demandeAjouts;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllDemandes")
    List<DemandeAjout> getAllDemandes() throws ResourceNotFoundException {
        return demandeAjoutService.getAllDemandeAjout();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/updateDemandeAjout")
    DemandeAjout updateDemandeAjout(@RequestBody Map<String,String> json) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Long idDemandeAjout = Long.parseLong(json.get("idDemandeAjout"));
        String ville = json.get("ville");
        String pays = json.get("pays");
        LocalDate dateDebut = LocalDate.parse(json.get("dateDebut"),formatter);
        LocalDate dateFin = LocalDate.parse(json.get("dateFin"),formatter);

        return demandeAjoutService.updateDemandeAjout(idDemandeAjout, ville, pays, dateDebut, dateFin);
    }

    @RequestMapping(method = RequestMethod.DELETE,path="/demandeAjout")
    Boolean deleteDemandeAjout(@RequestParam Map<String,String> json){
        Long idDemandeAjout = Long.parseLong(json.get("idDemandeAjout"));

        DemandeAjout demandeAjout = demandeAjoutService.getDemandeAjout(idDemandeAjout);
        Mobilite mobilite = demandeAjout.getMobilite();
        demandeAjout.setMobilite(null);
        mobiliteService.deleteMobilite(mobilite.getId());
        return demandeAjoutService.deleteDemandeAjout(idDemandeAjout);
    }
}
