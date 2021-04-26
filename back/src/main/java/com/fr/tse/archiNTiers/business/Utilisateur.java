package com.fr.tse.archiNTiers.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name="promotion")
    private String promotion;

    @Column(name="login")
    private String login;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "profil")
    private String profil;

    @JsonIgnoreProperties("utilisateur")
    @OneToMany(mappedBy = "utilisateur")
    private List<DemandeAjout> demandeAjouts;

    public Utilisateur(){}

    public Utilisateur(String nom, String prenom, String promotion, String motDePasse){
        this.nom = nom;
        this.prenom = prenom;
        this.promotion = promotion;
        this.login = nom.toLowerCase()+"."+prenom.toLowerCase();
        this. motDePasse = motDePasse;
        this.profil = "utilisateur";
        this.demandeAjouts = new ArrayList<DemandeAjout>();
    };

}
