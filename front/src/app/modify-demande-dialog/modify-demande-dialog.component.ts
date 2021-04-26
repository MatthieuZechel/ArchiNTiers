import { Component, Inject, OnInit } from '@angular/core';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-modify-demande-dialog',
  templateUrl: './modify-demande-dialog.component.html',
  styleUrls: ['./modify-demande-dialog.component.css']
})
export class ModifyDemandeDialogComponent implements OnInit {

  idDemandeAjout : any;
  paysDestination: string;
  villeDestination: string;
  dateDebut: Date;
  dateFin: Date;

  constructor(private utilisateurService : UtilisateurService) { 
  }

  ngOnInit(): void {

    this.idDemandeAjout = sessionStorage.getItem("idDemandeAjout");
  }

  modifyMobility(){
    this.utilisateurService.sendUpdateDemandeAjout(this.idDemandeAjout,this.villeDestination,this.paysDestination,this.dateDebut,this.dateFin).subscribe((data: any = [])=>{
    });
  }

}
