import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import {AuthenticationService} from '../../../authentication.service'
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-logincomp',
  templateUrl: './logincomp.component.html',
  styleUrls: ['./logincomp.component.css']
})
export class LogincompComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  correctDetails =false;

  logincredentials: any=[];

  constructor(private formBuilder: FormBuilder,private AuthenticationService: AuthenticationService) { }

  ngOnInit() {

    // this.loginForm = this.formBuilder.group({
    //   username: ['', Validators.required],
    //   password: ['', Validators.required]
    // })

    this.loginForm=new FormGroup({
      username: new FormControl('',Validators.required),
      password: new FormControl('',Validators.required)
    });
    // console.log(this.loginForm.value);


    this.AuthenticationService.getLoginCredentials()
      .subscribe(data =>{
        this.logincredentials=data;

     

        // console.log(this.logincredentials);

      })

    // this.loginForm.reset({username: 'Nancy', disabled: true, password: 'Drew'});
    // console.log(this.loginForm.value);

  }
  get f() { return this.loginForm.controls; }


  loginUser() {
    // event.preventDefault();

    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    this.loading = true;


    for(const login in this.logincredentials)
      {
        console.log(this.logincredentials[login]);
        
        if(this.logincredentials[login].firstname == this.loginForm.value.username
          && this.logincredentials[login].lastname == this.loginForm.value.password
          ){
          this.correctDetails=true;
        }

      }
      if(this.correctDetails==true)
      {
        
      }
      else{
        this.loading=false;
        this.loginForm.patchValue({"username":'',"password":''})
        return;
      }
      console.log(this.loginForm.valid);
      this.signUpJsonPost();
    // console.log(this.loginForm.value);

    // const target=event.target;
    // const username=target.querySelector('#username').value;
    // const password=target.querySelector('#password').value;

    // console.log(username);
    // console.log(password);
  }

  signUpJsonPost()
  {
    let formObj = this.loginForm.getRawValue(); // {name: '', description: ''}
        let serializedForm = JSON.stringify(formObj);
        console.log(serializedForm);

        // this.http.post("www.domain.com/api", serializedForm)
        //     .subscribe(
        //         data => console.log("success!", data),
        //         error => console.error("couldn't post because", error)
        //     );

  }

}
