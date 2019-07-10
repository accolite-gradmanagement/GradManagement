import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { FrontpageComponent } from './frontpage/frontpage.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { UserComponent } from './user/user.component';
import { AdminguardGuard } from '../adminguard.guard';

const routes: Routes = [
  
  {path:'signup',component:SignupComponent},
  {path:'login',component:LoginComponent},
  {path:'home',component:HomeComponent,canActivate: [AdminguardGuard]},
  {path:'admin-user',component:AdminComponent,canActivate: [AdminguardGuard]},
  {path:'front',component:FrontpageComponent},
  {path: 'user', component: UserComponent,canActivate: [AdminguardGuard]},
  {path:'resetpassword',component:ResetpasswordComponent},
  {path:'',redirectTo:'front',pathMatch:'full'}
  
  ];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MainRoutingModule { }
