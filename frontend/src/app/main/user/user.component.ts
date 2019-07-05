    
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, PatternValidator } from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  private loggedInStatus=JSON.parse(localStorage.getItem('loggedIn')||'false');
  loginForm: FormGroup;
   id :any;
 constructor(private httpClient:HttpClient, private router:Router) {
    console.log(this.loggedInStatus);

  }

  //get f() { return this.loginForm.controls; }
 ngOnInit() {

   this.loginForm=new FormGroup({
     first_name: new FormControl('',Validators.required),
     last_name: new FormControl('',Validators.required),
     mobile_no: new FormControl('', [Validators.required,Validators.pattern('^[0-9]{10}$')]),

   });

 }

 updateUser(event){
   event.preventDefault();
   console.log(this.loginForm);
   let dataToSend = {
     userId : this.loggedInStatus.userId,
     firstName: this.loginForm.get('first_name').value,
     lastName: this.loginForm.get('last_name').value,
     mobileNo : this.loginForm.get('mobile_no').value
   }

   let serializedForm = JSON.stringify(dataToSend);

   let h = new HttpHeaders({'Content-Type':'application/json'});
   this.id = this.loggedInStatus.userId; 
   this.httpClient.post("http://10.4.14.76:8080/msgrad/update",serializedForm,{headers:h})
   .subscribe(
     data  => { if(data)
                 {
                 alert("updated successfully");
                 this.router.navigate(['currentUser']);
                 }
                 else
                 {
                   alert("could not update");
                   console.log("error");
                 }

     },
     error  => {console.log("Error", error);}
   )
 
 }

}
