package com.fr.tse.archiNTiers.service;

import com.fr.tse.archiNTiers.business.Utilisateur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public interface LoginService {
    Utilisateur connexion(String login, String motDePasse);

}
