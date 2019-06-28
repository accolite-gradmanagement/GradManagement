import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { CanActivate, ActivatedRouteSnapshot, RouterLink, RouterStateSnapshot } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.css']
})
export class UserDataComponent implements OnInit {

 

  userForm: FormGroup;
  loading = false;
  submitted = false;
  notvalid = false;
  datas : any;

  constructor(private httpClient:HttpClient, private router:Router) {
   
   }

  ngOnInit() {
    localStorage.clear();
    this.userForm=new FormGroup({
      username: new FormControl('',Validators.required),
    });




    /* ********************/
    this.httpClient.get("http://localhost:8080/msgrad/getAll").subscribe(
      data  => {console.log("Get Request is successful ",
      this.datas = (data));},
      error  => {console.log("Error", error);}
    )

  }
  get f() { return this.userForm.controls; }


  addUserPost(){
    this.submitted = true;
    let dataToSend = {
      emailId: this.userForm.get('username').value,
    }

    let serializedForm = JSON.stringify(dataToSend);

    let h = new HttpHeaders({'Content-Type':'application/json'});
   
    this.httpClient.post("http://localhost:8080/msgrad/addEmployee",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data)
                  {
             
                  localStorage.setItem('loggedIn', JSON.stringify(data));
                    
                  }
                  else
                  {
                    this.submitted = false;
                    console.log("error");
                  }

      },
      error  => {console.log("Error", error);}
    )
  }



}
