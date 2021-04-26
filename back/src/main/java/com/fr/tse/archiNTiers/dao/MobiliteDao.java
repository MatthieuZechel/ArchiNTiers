package com.fr.tse.archiNTiers.dao;

import com.fr.tse.archiNTiers.business.Mobilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobiliteDao extends JpaRepository<Mobilite, Long> {
}
