import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddMobilityComponent } from './add-mobility/add-mobility.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { MobilityTableComponent } from './mobility-table/mobility-table.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'register',
    component: RegisterComponent
  },
  {
    path:'home',
    component: HomePageComponent
  },
  {
    path:'addMobility',
    component: AddMobilityComponent
  },
  {
    path:'mobilityTable',
    component: MobilityTableComponent
  },
  {
    path: '**',
    redirectTo: 'login',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
