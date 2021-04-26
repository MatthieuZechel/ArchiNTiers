package com.fr.tse.archiNTiers.service.impl;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import com.fr.tse.archiNTiers.business.Mobilite;
import com.fr.tse.archiNTiers.dao.MobiliteDao;
import com.fr.tse.archiNTiers.service.MobiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MobiliteServiceImpl implements MobiliteService {

    @Autowired
    private MobiliteDao mobiliteDao;

    @Override
    public Mobilite creerMobilite(String ville, String pays, LocalDate dateDebut, LocalDate dateFin, DemandeAjout demandeAjout) {
        Mobilite mobilite = new Mobilite(ville, pays, dateDebut, dateFin, demandeAjout);
        return mobiliteDao.save(mobilite);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Mobilite> getAllMobilites() {
        return mobiliteDao.findAll();
    }

    @Override
    public Mobilite getMobilite(Long idMobilite) {
        Optional<Mobilite> mobiliteOptional = mobiliteDao.findById(idMobilite);
        if(mobiliteOptional.isPresent())
        {
            return mobiliteOptional.get();
        }
        return null;
    }

    @Override
    public Mobilite modifierMobilite(Long idMobilite,String ville, String pays, LocalDate dateDebut, LocalDate dateFin) {
        Mobilite mobilite = getMobilite(idMobilite);

        if(ville !=null)
            mobilite.setVille(ville);
        if(pays != null)
            mobilite.setPays(pays);
        if(dateDebut !=null)
            mobilite.setDateDebut(dateDebut);
        if(dateFin != null)
            mobilite.setDateFin(dateFin);

        return mobiliteDao.save(mobilite);
    }

    @Override
    public Boolean deleteMobilite(Long idMobilite) {
        Optional<Mobilite> demandeMobiliteOptional = mobiliteDao.findById(idMobilite);
        if(!demandeMobiliteOptional.isPresent()) {
            return false;
        }
        mobiliteDao.delete(demandeMobiliteOptional.get());
        return true;
    }
}
