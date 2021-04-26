package com.fr.tse.archiNTiers.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="mobilites")
public class Mobilite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ville")
    private String ville;

    @Column(name="pays")
    private String pays;

    @Column(name="date_debut")
    private LocalDate dateDebut;

    @Column(name="date_fin")
    private LocalDate dateFin;

    @JsonIgnoreProperties("mobilite")
    @OneToOne
    @JoinColumn(name = "demande_id", referencedColumnName = "id")
    private DemandeAjout demandeAjout;

    public Mobilite(){};

    public Mobilite(String ville, String pays, LocalDate dateDebut, LocalDate dateFin, DemandeAjout demandeAjout){
        this.ville = ville;
        this.pays = pays;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.demandeAjout = demandeAjout;
    }
}
