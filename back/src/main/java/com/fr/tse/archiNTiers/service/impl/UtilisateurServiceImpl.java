package com.fr.tse.archiNTiers.service.impl;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Utilisateur;
import com.fr.tse.archiNTiers.dao.UtilisateurDao;
import com.fr.tse.archiNTiers.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Override
    public Utilisateur creerUtilisateur(String nom, String prenom, String promotion, String motDePasse) {
        Utilisateur utilisateur = new Utilisateur(nom,prenom,promotion,motDePasse);
        return utilisateurDao.save(utilisateur);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurDao.findAll();
    }

    @Override
    public Utilisateur getUtilisateur(Long idUtilisateur) {
        Optional<Utilisateur> utilisateur = utilisateurDao.findById(idUtilisateur);
        if( utilisateur.isPresent()){
            return utilisateur.get();
        }
        return null;
    }
}
