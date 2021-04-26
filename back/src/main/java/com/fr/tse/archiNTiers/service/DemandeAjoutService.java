package com.fr.tse.archiNTiers.service;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Utilisateur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public interface DemandeAjoutService {

    DemandeAjout creerDemandeAjout(Utilisateur utilisateur, String ville, String pays, LocalDate dateDebut, LocalDate dateFin);

    DemandeAjout getDemandeAjout(Long idDemandeAjout);

    List<DemandeAjout> getAllDemandeAjout();

    List<DemandeAjout> getUtilisateurAllDemandeAjout(Long idUtilisateur);

    DemandeAjout updateDemandeAjout(Long idDemandeAjout, String ville, String pays, LocalDate dateDebut, LocalDate dateFin);

    Boolean deleteDemandeAjout(Long idDemandeAjout);
}
