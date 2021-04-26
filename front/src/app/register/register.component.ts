import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  nom: string;
  prenom: string;
  promotion: string;
  pwd1: string;
  pwd2: string;
 
  constructor(private router : Router, private loginService : LoginService) { }

  ngOnInit(): void {
  }

  createAccount() {
    if (this.pwd1 == this.pwd2 ) {
      this.loginService.sendRegisterRequest( this.nom, this.prenom,this.promotion,this.pwd1).subscribe((data: any = [])=>{
        alert("Votre compte a été créé");
        this.router.navigate(['/login']);
      }) 
    }
    else{
      alert("Les deux mots de passe ne sont pas identiques, veuillez réessayer");
    }

  }

  backToLogin() {
    this.router.navigate(['/login']);
  }

}
