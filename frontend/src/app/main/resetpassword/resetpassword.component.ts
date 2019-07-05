import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.scss']
})
export class ResetpasswordComponent implements OnInit {

  ResetPasswordForm: FormGroup;
  otpbackend:any;
  details:boolean=false;
  constructor(private toastr:ToastrService,private httpClient:HttpClient, private router:Router) { }

  ngOnInit() {
    this.ResetPasswordForm=new FormGroup({
      emailId: new FormControl('',Validators.required),
      otp: new FormControl('',Validators.required),
      password: new FormControl('',Validators.required)
    });

   
  }

verifyOtp()
{
  if(this.otpbackend==this.ResetPasswordForm.get('otp').value)
  {
      this.details=true;
      this.toastr.success("Otp verified","Success");
  }
  else{
      this.toastr.error("Otp Invalid","Error");
  }
}

  
  resetUser()
  {
    let dataToSend = {
      toMail : this.ResetPasswordForm.get('emailId').value,
      subject: "forgot password",
      text: "hello"
    }

    let serializedForm = JSON.stringify(dataToSend);

    let h = new HttpHeaders({'Content-Type':'application/json'});
   
    this.httpClient.post("http://10.4.14.76:8080/msgrad/passwordrecovery",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data)
                  {
                    console.log(data);
                    this.toastr.success("Otp sent to mail","Success");
                      this.otpbackend=data;
                  }
                  else
                  {
                   
                  }

      },
      error  => {console.log("Error", error);}
    )
  }

  createNewPassword()
  {
      console.log(this.ResetPasswordForm);
      let dataToSend = {
        username : this.ResetPasswordForm.get('emailId').value,
        pass_word: this.ResetPasswordForm.get('password').value
      }
  
      let serializedForm = JSON.stringify(dataToSend);
  
      let h = new HttpHeaders({'Content-Type':'application/json'});
     
      this.httpClient.post("http://10.4.14.76:8080/msgrad/setPassword",serializedForm,{headers:h})
      .subscribe(
        data  => { if(data)
                    {
                      console.log(data);
                      this.toastr.success("Password reset successful","Success");
                      this.router.navigate(['login'])
                    }
                    else
                    {
                     
                    }
  
        },
        error  => {console.log("Error", error);}
      )

  }

}
