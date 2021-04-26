import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  nom: string;
  prenom: string;
  profil: string;

  constructor(private router: Router) { 
  }

  ngOnInit(): void {
    
    this.nom = sessionStorage.getItem("nom");
    this.prenom = sessionStorage.getItem("prenom");
    this.profil = sessionStorage.getItem("profil");
  }

  deconnexion(){
    sessionStorage.clear();
  }

  home(){

    this.router.navigate(['/home']);
  }

  mesDemandes(){
    this.router.navigate(['/mobilityTable'])
  }

  nouvelleDemande(){
    this.router.navigate(['/addMobility'])
  }

}
