import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { CanActivate, ActivatedRouteSnapshot, RouterLink, RouterStateSnapshot } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  
  userForm: FormGroup;
  loading = false;
  submitted = false;
  notvalid = false;
  datas : any;

  constructor(private toastr:ToastrService,private httpClient:HttpClient, private router:Router) {
   
   }

  ngOnInit() {
    //localStorage.clear();
    this.userForm=new FormGroup({
      username: new FormControl('',Validators.required),
    });




    /* ********************/
    this.httpClient.get("http://10.4.14.76:8080/msgrad/getAll").subscribe(
      data  => {console.log("Get Request is successful ",
      this.datas = (data));
    },
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
   
    this.httpClient.post("http://10.4.14.76:8080/msgrad/addEmployee",serializedForm,{headers:h})
    .subscribe(
      data  => { if(data)
                  {
             
                  if(data==1)
                  {
                    // alert("employee added successfully")
                    // this.router.navigate(['./employeeData'])
                   /*  this.router.navigateByUrl('/employeeData', {skipLocationChange: true}).then(()=>
                    this.router.navigate(["employeeData"])); */
                   
                   this.showToaster();
                  }                  
                  else
                  {
                    alert("employee not added");
                    this.submitted = false;
                    console.log("error");
                  }
                }

      },
      error  => {console.log("Error", error);}
    )
  }


  showToaster()
  {
    this.toastr.success('Successfully added employee!!','success');
    this.ngOnInit();
    
  }


}
