import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormGroup;
  submitted: Boolean = false;  
  pwdMatched: Boolean = true;

  constructor(private formBuilder: FormBuilder,
    private httpClient : HttpClient,
    private router:Router
    ){
      document.body.style.backgroundImage = null;
    }

  ngOnInit() {
    this.signUpForm = this.formBuilder.group({
      emailID: ['', [Validators.required,Validators.pattern('^[a-zA-Z0-9._]+$')]],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      firstName: ['', [Validators.required,Validators.pattern('^[a-zA-Z]+$')]],
      lastName: ['', [Validators.required,Validators.pattern('^[a-zA-Z]+$')]],
      phoneNumber: ['', [Validators.required,Validators.pattern('^[0-9]{10}$')]],
      dateOfBirth: ['', Validators.required],
      gender: ['',Validators.required],
      role:['',Validators.required],
      termsAndConditions: [false, Validators.requiredTrue]
    });
  }
  
  signUpSubmit()
  {
    this.submitted = true;
    if(this.signUpForm.get('password').value != this.signUpForm.get('confirmPassword').value)
    {
      this.pwdMatched = false;
    }
    else
    {
      this.pwdMatched = true;
    }

    
    console.log(this.pwdMatched);
    console.log(this.signUpForm.valid);
    console.log(this.signUpForm)
    if(this.signUpForm.valid == true && this.pwdMatched == true)
    {
      this.signUpJsonPost();
      return;
    }
    else
    {
      //do not sign up
      return;
    }
  }  

  signUpClear()
  {
    this.submitted = false;
    this.signUpForm.reset();
  }

  signUpCancel()
  {
    this.httpClient.get("http://localhost:8080/msgrad/getAll").subscribe(
      data  => {console.log("Get Request is successful ", data);},
      error  => {console.log("Error", error);}
    )

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
      role:this.signUpForm.get('role').value
    }

    let serializedForm = JSON.stringify(dataToSend);

    console.log(serializedForm);

    let h = new HttpHeaders({'Content-Type':'application/json'});
   
    this.httpClient.post("http://localhost:8080/msgrad/putUser",serializedForm,{headers:h})
    .subscribe(
      data  => {if(data==0)
        {
          alert("email present" )
          this.router.navigate(['login/signup']);
        }
        else if(data==2)
        {
          alert("username present")
          this.router.navigate(['/login/signup']);
        }
        else
        this.router.navigate(['/login']);
        console.log("POST Request is successful ", data);},
      error  => {console.log("Error", error);}
    )
  }
}  
