import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './main/signup/signup.component';
import { LoginComponent } from './main/login/login.component';
import { HomeComponent } from './main/home/home.component';
import { AdminComponent } from './main/admin/admin.component';
import { ResetpasswordComponent } from './main/resetpassword/resetpassword.component';

const routes: Routes = [
{path:'signup',component:SignupComponent},
{path:'login',component:LoginComponent},
{path:'home',component:HomeComponent},
{path:'admin',component:AdminComponent},
{path:'resetpassword',component:ResetpasswordComponent},
{path:'',redirectTo:'login',pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
