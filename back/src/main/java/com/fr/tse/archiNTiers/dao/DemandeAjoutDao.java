package com.fr.tse.archiNTiers.dao;

import com.fr.tse.archiNTiers.business.DemandeAjout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeAjoutDao extends JpaRepository<DemandeAjout, Long> {
}
