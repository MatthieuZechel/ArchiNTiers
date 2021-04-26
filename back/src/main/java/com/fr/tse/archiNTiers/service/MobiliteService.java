package com.fr.tse.archiNTiers.service;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Mobilite;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public interface MobiliteService {

    Mobilite creerMobilite(String ville, String pays, LocalDate dateDebut, LocalDate dateFin, DemandeAjout demandeAjout);

    List<Mobilite> getAllMobilites();

    Mobilite getMobilite(Long idMobilite);

    Mobilite modifierMobilite(Long idMobilite,String ville, String pays, LocalDate dateDebut, LocalDate dateFin);

    Boolean deleteMobilite(Long idMobilite);
}
