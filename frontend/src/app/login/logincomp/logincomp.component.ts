import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { CanActivate, ActivatedRouteSnapshot, RouterLink, RouterStateSnapshot } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-logincomp',
  templateUrl: './logincomp.component.html',
  styleUrls: ['./logincomp.component.css']
})
export class LogincompComponent implements OnInit {

  

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  correctDetails:boolean;

  constructor(private httpClient:HttpClient, private router:Router) {
    document.body.style.backgroundImage = "url('./../../../accolite.jpg')";
    document.body.style.backgroundPosition = "center center";
    document.body.style.backgroundRepeat = "no-repeat";
    document.body.style.backgroundAttachment = "fixed";
    document.body.style.backgroundSize = "cover";
   }

  ngOnInit() {
    localStorage.clear();
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
   
    this.httpClient.post("http://localhost:8080/msgrad/login",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data)
                  {
             
                  localStorage.setItem('loggedIn', JSON.stringify(data));
                    
                  this.router.navigate(['login/homepage']);
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


}
