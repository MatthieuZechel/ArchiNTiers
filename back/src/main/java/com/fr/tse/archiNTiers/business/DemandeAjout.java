package com.fr.tse.archiNTiers.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="demandes_ajout")
public class DemandeAjout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_soumission")
    private LocalDateTime dateSoumission;


    @ManyToOne
    @JoinColumn(name="id_utilisateur", nullable=false)
    private Utilisateur utilisateur;

    @JsonIgnoreProperties("demandeAjout")
    @OneToOne(mappedBy = "demandeAjout", cascade = CascadeType.ALL)
    private Mobilite mobilite;

    @Column(name = "ville")
    private String ville;

    @Column(name="pays")
    private String pays;

    @Column(name="date_debut")
    private LocalDate dateDebut;

    @Column(name="date_fin")
    private LocalDate dateFin;

    public DemandeAjout(){};

    public DemandeAjout(Utilisateur utilisateur,String ville, String pays, LocalDate dateDebut, LocalDate dateFin){
        this.dateSoumission = LocalDateTime.now();
        this.utilisateur = utilisateur;
        this.ville = ville;
        this.pays = pays;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.mobilite = null;
    }
}
