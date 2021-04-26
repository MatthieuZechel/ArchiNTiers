package com.fr.tse.archiNTiers.dao;

import com.fr.tse.archiNTiers.business.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {
}
