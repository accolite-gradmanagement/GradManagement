import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
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

  constructor(private httpClient:HttpClient, private router:Router) { }

  ngOnInit() {
    this.loginForm=new FormGroup({
      username: new FormControl('',Validators.required),
      password: new FormControl('',Validators.required)
    });
  }
  get f() { return this.loginForm.controls; }


  loginUser() {
    
    // console.log(this.loginForm.valid);
    // console.log(this.loginForm);
    // event.preventDefault();

    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    
    if(this.loginForm.valid)
    {
      this.loginpost();
    
    }
  }

  loginpost(){
    let dataToSend = {
      username: this.loginForm.get('username').value,
      pass_word: this.loginForm.get('password').value
    }

    let serializedForm = JSON.stringify(dataToSend);

    // console.log(serializedForm);

    let h = new HttpHeaders({'Content-Type':'application/json'});
   
    this.httpClient.post("http://localhost:8080/msgrad/login",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data==true)
                  {
                  
                  console.log("success");
                  this.router.navigate(['login/admin']);
                  }else
                  {
                    this.correctDetails=false;
                    console.log("error");
                  }

      },
      error  => {console.log("Error", error);}
    )
  }

}
