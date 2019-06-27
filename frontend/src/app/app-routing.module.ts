import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomepageComponent } from './login/homepage/homepage.component';
import { LogincompComponent } from './login/logincomp/logincomp.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';

const routes: Routes = [
// {  
  // path: 'login/admin',
  // component: AdminComponent,
  // canActivate: [LoginGuard]},
{path:'login/signup',component:SignUpComponent},
{path:'login/homepage',component:HomepageComponent},
{path:'login',component:LogincompComponent},
{path:'',redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
