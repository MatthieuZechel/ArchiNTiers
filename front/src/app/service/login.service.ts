import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import {  throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private LOGIN_REQ = "http://localhost:8080/connexion";  //POST(login, mdp)
  private REGISTER_REQ = "http://localhost:8080/creerUtilisateur"; //POST(nom,prenom,mdp)

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

  public sendLoginRequest(login, mdp){
    const options = { login: login, motDePasse: mdp};
    return this.httpClient.post(this.LOGIN_REQ, options);
  } 

  public sendRegisterRequest(nom, prenom, promotion, mdp){
    const options = { nom: nom, prenom: prenom, promotion: promotion, motDePasse: mdp} ;
    return this.httpClient.post(this.REGISTER_REQ, options);
  }
}
