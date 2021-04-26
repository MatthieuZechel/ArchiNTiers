package com.fr.tse.archiNTiers.service;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Utilisateur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public interface UtilisateurService {

    Utilisateur creerUtilisateur(String nom, String prenom, String promotion, String motDePasse);

    List<Utilisateur> getAllUtilisateurs();

    Utilisateur getUtilisateur(Long idUtilisateur);
}
