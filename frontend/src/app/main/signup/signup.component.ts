import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})

export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  submitted: Boolean = false;  
  pwdMatched: Boolean = true;

  constructor(private toastr:ToastrService,private formBuilder: FormBuilder,
    private httpClient : HttpClient,
    private router:Router
    ){}

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      emailID: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      firstName: ['', [Validators.required,Validators.pattern('^[a-zA-Z]+$')]],
      lastName: ['', [Validators.required,Validators.pattern('^[a-zA-Z]+$')]],
      phoneNumber: ['', [Validators.required,Validators.pattern('^[0-9]{10}$')]],
      dateOfBirth: ['', Validators.required],
      gender: ['',Validators.required],
      // termsAndConditions: [false, Validators.requiredTrue]
    });
  }

  isvalid()
  {
    if(this.signUpForm.valid)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  pwdMatch()
  {
    if(this.signUpForm.get('password').value == this.signUpForm.get('confirmPassword').value)
    {
      return false;
    }
    else
    {
      return true;
    }
  }

  signUpSubmit()
  {
    // this.submitted=true;
    // if(!this.signUpForm.valid)
    // {
    //   return;
    // }
    console.log(this.signUpForm.valid);
    console.log(this.signUpForm)
    this.signUpJsonPost();
    return;
  }  

  signUpClear()
  {
    this.submitted = false;
    this.signUpForm.reset();
    this.signUpForm.get('gender').setValue("")
  }

  signUpCancel()
  {
    this.router.navigate(['login']);
  }

  

  signUpJsonPost()
  {
    let dataToSend = {
      firstName: this.signUpForm.get('firstName').value,
      lastName: this.signUpForm.get('lastName').value,
      mobileNo: this.signUpForm.get('phoneNumber').value,
      gender: this.signUpForm.get('gender').value,
      emailId: this.signUpForm.get('emailID').value,  
      dob: this.signUpForm.get('dateOfBirth').value,
      passWord: this.signUpForm.get('password').value,
      role:"grad"
    }
    
    let serializedForm = JSON.stringify(dataToSend);

    console.log(serializedForm);

    let h = new HttpHeaders({'Content-Type':'application/json'});
    this.httpClient.post("http://10.4.14.76:8080/msgrad/putUser",serializedForm,{headers:h})
    .subscribe(
      data  => {if(data==0)
        {
          this.toastr.warning("Email already present","Warning");
          this.router.navigate(['signup']);
        }
        else if(data==2)
        {
          this.toastr.warning("Username already present","Warning");
          this.router.navigate(['/signup']);
        }
        else
        this.router.navigate(['/login']);
        console.log("POST Request is successful ", data);},
      error  => {console.log("Error", error);}
    )
    this.router.navigate(['login']);
  
  } 
}  

