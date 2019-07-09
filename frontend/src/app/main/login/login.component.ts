import { Component, OnInit } from '@angular/core';
import {AuthService,SocialUser,GoogleLoginProvider} from 'ng4-social-login';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import {ToastrService} from 'ngx-toastr';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  private loggedInStatus=JSON.parse(localStorage.getItem('loggedIn')||'false');

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  correctDetails:boolean;


  constructor(private toastr:ToastrService,private httpClient:HttpClient, private router:Router,private socialAuthService: AuthService) { 
    if(this.loggedInStatus)
    {
          this.router.navigate(['home']);
    }
  }

  ngOnInit() {

    // localStorage.clear();
    this.loginForm=new FormGroup({
      username: new FormControl('',Validators.required),
      password: new FormControl('',Validators.required)
    });


  }
  get f() { return this.loginForm.controls; }


  loginUser() {
    
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    
    if(this.loginForm.valid)
    {
      this.correctDetails=true;
      this.loginpost();
    
    }
  }


  loginpost(){
    let dataToSend = {
      username: this.loginForm.get('username').value,
      pass_word: this.loginForm.get('password').value
    }

    let serializedForm = JSON.stringify(dataToSend);

    let h = new HttpHeaders({'Content-Type':'application/json'});
   
    this.httpClient.post("http://10.4.14.76:8080/msgrad/login",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data)
                  {
                  localStorage.setItem('loggedIn', JSON.stringify(data)); 
                  this.router.navigate(['/home']);
                  // this.ngOnInit();
                  location.reload();
                  }
                  else
                  {
                    this.correctDetails=false;
                    console.log("error");
                  }

      },
      error  => {console.log("Error", error);}
    )
  }

                
  





  public user:any=SocialUser;
  googleLogin(event){
  
    event.preventDefault();
      // console.log("wnegvhe")
    this.socialAuthService.signIn(GoogleLoginProvider.PROVIDER_ID).then((userData) =>{
      this.user= userData;
      console.log(this.user);
      let info = {
        // username: this.user.name,
        email:this.user.email
        // pass_word: this.loginForm.get('password').value
      }
      console.log(info);

      let serializedForm = JSON.stringify(info);

    let h = new HttpHeaders({'Content-Type':'application/json'});
   
    this.httpClient.post("http://10.4.14.76:8080/msgrad/googlelogin",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data)
                  {
                  localStorage.setItem('loggedIn', JSON.stringify(data)); 
                  this.router.navigate(['home']);
                  location.reload();
                  }
                  else
                  {
                    this.correctDetails=false;
                    console.log("error");
                    this.toastr.warning("Please signin before login","Warning")
                  }

      },
      error  => {console.log("Error", error);}
    )





      // sessionStorage.setItem('loggedIn', JSON.stringify(info));
      //  this.router.navigate(['home']);
    })

    }
}
