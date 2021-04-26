import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {  throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  dateDebutString : String;
  dateFinString : String;

  private CREERDEMANDEAJOUT_REQ = "http://localhost:8080/creerDemandeAjout";  //POST(utilisateur, ville, pays, dateDebut, dateFin)
  private GETUTILISATEURALLDEMANDES_REQ = "http://localhost:8080/getUtilisateurAllDemandes"; //GET(idUtilisateur)
  private MODIFYDEMANDE_REQ = "http://localhost:8080/updateDemandeAjout"; //POST(idDemandeAjout, ville, pays,dateDebut,dateFin)
  private DELETEDEMANDE_REQ = "http://localhost:8080/demandeAjout"; //DELETE(idDemandeAjout)

  constructor(private httpClient : HttpClient) { }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  public sendcreerDemandeAjout(utilisateur, ville, pays, dateDebut,dateFin){
    let re = /\//gi;
    this.dateDebutString = dateDebut.toLocaleDateString().replace(re,'-');
    this.dateFinString = dateFin.toLocaleDateString().replace(re,'-');
    const options = { idUtilisateur: utilisateur, ville: ville, pays: pays, dateDebut: this.dateDebutString, dateFin : this.dateFinString} ;
    console.log(options);
    return this.httpClient.post(this.CREERDEMANDEAJOUT_REQ, options);
  }

  public sendGetUtilisateurAllDemandes(idUtilisateur){
    // Initialize Params Object
    let params = new HttpParams();

    // Begin assigning parameters
    params = params.append('idUtilisateur', idUtilisateur);
    return this.httpClient.get(this.GETUTILISATEURALLDEMANDES_REQ, { params: params });
  }

  public sendUpdateDemandeAjout(idDemandeAjout, ville, pays,dateDebut,dateFin){
    let re = /\//gi;
    this.dateDebutString = dateDebut.toLocaleDateString().replace(re,'-');
    this.dateFinString = dateFin.toLocaleDateString().replace(re,'-');
    const options = { idDemandeAjout: idDemandeAjout, ville: ville, pays: pays, dateDebut: this.dateDebutString, dateFin : this.dateFinString} ;
    return this.httpClient.post(this.MODIFYDEMANDE_REQ, options);

  }

  public sendDeleteDemandeRequest(idDemandeAjout){
    // Initialize Params Object
    let params = new HttpParams();

    params = params.append('idDemandeAjout', idDemandeAjout);
    return this.httpClient.delete(this.DELETEDEMANDE_REQ, { params: params });
  }


}
