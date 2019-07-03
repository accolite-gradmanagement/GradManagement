import { Component, OnInit } from '@angular/core';
import {AuthService,SocialUser,GoogleLoginProvider} from 'ng4-social-login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {



  constructor(private router: Router,private socialAuthService: AuthService) { }

  ngOnInit() {
  }

  public user:any=SocialUser;
  googleLogin(event){
  
    event.preventDefault();
      console.log("wnegvhe")
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID).then((userData) =>{
      this.user= userData;
      console.log(this.user);
      let info = {
        username: this.user.name,
        email:this.user.email
        // pass_word: this.loginForm.get('password').value
      }
      console.log(info);
      sessionStorage.setItem('loggedIn', JSON.stringify(info));
      // this.router.navigate(['login/homepage']);
    })

    }
}
