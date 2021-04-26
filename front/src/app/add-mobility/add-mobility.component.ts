import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-add-mobility',
  templateUrl: './add-mobility.component.html',
  styleUrls: ['./add-mobility.component.css']
})
export class AddMobilityComponent implements OnInit {

  promotion : string;
  paysDestination : string;
  villeDestination : string;
  dateDebut : Date;
  dateFin : Date;

  constructor(private router: Router, private utilisateurService : UtilisateurService) { }

  ngOnInit(): void {
  }

  addMobility(){
    this.utilisateurService.sendcreerDemandeAjout(sessionStorage.getItem("id"),this.villeDestination,this.paysDestination,this.dateDebut,this.dateFin).subscribe( (res: any = [] )  =>{
      alert("La demande a bien été ajoutée")
    })
  }

  returnHome(){this.router.navigateByUrl('/home')}

}
