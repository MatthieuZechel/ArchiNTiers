package com.fr.tse.archiNTiers.service.impl;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Mobilite;
import com.fr.tse.archiNTiers.business.Utilisateur;
import com.fr.tse.archiNTiers.dao.DemandeAjoutDao;
import com.fr.tse.archiNTiers.dao.MobiliteDao;
import com.fr.tse.archiNTiers.service.DemandeAjoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DemandeAjoutServiceImpl implements DemandeAjoutService {

    @Autowired
    private DemandeAjoutDao demandeAjoutDao;

    @Override
    public DemandeAjout creerDemandeAjout(Utilisateur utilisateur, String ville, String pays, LocalDate dateDebut, LocalDate dateFin) {
        DemandeAjout demandeAjout = new DemandeAjout(utilisateur,ville,pays,dateDebut,dateFin);
        Mobilite mobilite = new Mobilite(ville, pays, dateDebut,dateFin,demandeAjout);
        demandeAjout.setMobilite(mobilite);
        return demandeAjoutDao.save(demandeAjout);
    }

    @Override
    public DemandeAjout getDemandeAjout(Long idDemandeAjout) {
        Optional<DemandeAjout> demandeAjoutOptional = demandeAjoutDao.findById(idDemandeAjout);
        if(demandeAjoutOptional.isPresent()){
            return demandeAjoutOptional.get();
        }
        return null;
    }

    @Override
    public List<DemandeAjout> getAllDemandeAjout() {
        return demandeAjoutDao.findAll();
    }

    @Override
    public List<DemandeAjout> getUtilisateurAllDemandeAjout(Long idUtilisateur) {
        return demandeAjoutDao.findAll().stream()
                .filter(demandeAjout -> demandeAjout.getUtilisateur().getId().equals(idUtilisateur))
                .collect(Collectors.toList());
    }

    @Override
    public DemandeAjout updateDemandeAjout(Long idDemandeAjout, String ville, String pays, LocalDate dateDebut, LocalDate dateFin) {

        DemandeAjout demandeAjout = getDemandeAjout(idDemandeAjout);
        Mobilite mobilite = demandeAjout.getMobilite();

        demandeAjout.setDateSoumission(LocalDateTime.now());
        if(ville != null) {
            demandeAjout.setVille(ville);
            mobilite.setVille(ville);
        }
        if(pays != null) {
            demandeAjout.setPays(pays);
            mobilite.setPays(pays);
        }
        if(dateDebut != null && dateDebut.isBefore(dateFin)) {
            demandeAjout.setDateDebut(dateDebut);
            mobilite.setDateDebut(dateDebut);
        }
        if(dateFin != null && dateFin.isAfter(dateDebut)) {
            demandeAjout.setDateFin(dateFin);
            mobilite.setDateFin(dateFin);
        }
        demandeAjout.setMobilite(mobilite);

        return demandeAjoutDao.save(demandeAjout);
    }

    @Override
    public Boolean deleteDemandeAjout(Long idDemandeAjout) {
        Optional<DemandeAjout> demandeAjoutOptional = demandeAjoutDao.findById(idDemandeAjout);
        if(!demandeAjoutOptional.isPresent()) {
            return false;
        }
        demandeAjoutDao.delete(demandeAjoutOptional.get());
        return true;
    }
}
