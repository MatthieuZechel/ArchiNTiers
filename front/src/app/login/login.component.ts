import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials: string;
  motDePasse: string;

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {

  }

  login(){
    this.loginService.sendLoginRequest(this.credentials, this.motDePasse).subscribe( (res: any = [] )  =>{

      sessionStorage.setItem("id", res.id)
      sessionStorage.setItem("prenom", res.prenom)
      sessionStorage.setItem("nom", res.nom)
      sessionStorage.setItem("profil", res.profil)
      


      this.router.navigate(['/home']);
    })
  }

  createAccount(){
    this.router.navigate(['/register']);
  }

}
