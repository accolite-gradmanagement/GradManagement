import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomepageComponent } from './login/homepage/homepage.component';
import { LogincompComponent } from './login/logincomp/logincomp.component';
import { SignUpComponent } from './login/sign-up/sign-up.component';
import { UserDataComponent } from './login/user-data/user-data.component';

const routes: Routes = [

{path:'login/signup',component:SignUpComponent},
{path:'login/homepage',component:HomepageComponent},
{path:'login',component:LogincompComponent},
{path:'employeeData', component: UserDataComponent},
{path:'',redirectTo:'login',pathMatch:'full'},
{path:'**',redirectTo:'login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
