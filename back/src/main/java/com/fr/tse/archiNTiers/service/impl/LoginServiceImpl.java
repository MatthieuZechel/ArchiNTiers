package com.fr.tse.archiNTiers.service.impl;

import com.fr.tse.archiNTiers.business.Utilisateur;
import com.fr.tse.archiNTiers.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService {

    @Autowired
    UtilisateurServiceImpl utilisateurService;

    @Override
    public Utilisateur connexion(String login, String motDePasse) {
        List<Utilisateur> utilisateurList = utilisateurService.getAllUtilisateurs();
        Utilisateur utilisateurConnected = utilisateurList.stream()
                .filter(utilisateur -> utilisateur.getLogin().equals(login))
                .findFirst().get();

        if(utilisateurConnected.getMotDePasse().equals(motDePasse)) {
            return utilisateurConnected;
        }

        return null;
    }
}
