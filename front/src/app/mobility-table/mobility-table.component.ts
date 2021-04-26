import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ModifyDemandeDialogComponent } from '../modify-demande-dialog/modify-demande-dialog.component';
import { AdministrateurService } from '../service/administrateur.service';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-mobility-table',
  templateUrl: './mobility-table.component.html',
  styleUrls: ['./mobility-table.component.css']
})
export class MobilityTableComponent implements OnInit {

  nom : string;
  prenom : string;
  profil : string;
  utilisateurDemandesList : any = [];
  administrateurDemandesList : any = [];
  displayedColumns: string[] = ["id","dateSoumission","dateDebut","dateFin","pays","ville","modifier_supprimer"];

  constructor(private utilisateurService : UtilisateurService , private administrateurService : AdministrateurService,public dialog : MatDialog) { }

  ngOnInit(): void {
    this.nom = sessionStorage.getItem("nom");
    this.prenom = sessionStorage.getItem("prenom");
    this.profil = sessionStorage.getItem("profil");
    this.getAllDemandesUtilisateur();
    this.getAllDemandesAdministrateur();
  }

  getAllDemandesUtilisateur(){
    this.utilisateurDemandesList =[];
    this.utilisateurService.sendGetUtilisateurAllDemandes(sessionStorage.getItem("id")).subscribe( (data : any = [] )  =>{
      this.utilisateurDemandesList = data;
    })
  }

  getAllDemandesAdministrateur(){
    this.administrateurDemandesList=[];
    this.administrateurService.sendGetUtilisateurAllDemandes().subscribe((data : any[]) =>{
      this.administrateurDemandesList = data;
    })
  }

  modifyDemande(idDemandeAjout){
    sessionStorage.setItem("idDemandeAjout",idDemandeAjout);
    const dialogRef = this.dialog.open(ModifyDemandeDialogComponent)
    .afterClosed()
    .subscribe(()=>this.ngOnInit());
  }

  deleteDemande(idDemandeAjout){
    sessionStorage.setItem("idDemandeAjout",idDemandeAjout);
    this.utilisateurService.sendDeleteDemandeRequest(idDemandeAjout).subscribe((data: any = [])=>{
      this.ngOnInit();
    });
  }

}
