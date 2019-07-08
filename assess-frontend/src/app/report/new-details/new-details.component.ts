import { Component, OnInit } from '@angular/core';
import { ReportService } from '../../report.service';
import { FormGroup, FormControl } from '@angular/forms'
import {IReport} from '../../IReport';
import{Tests} from '../../Tests';
import {Details} from '../../details';
import { Student } from 'src/app/student';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-new-details',
  templateUrl: './new-details.component.html',
  styleUrls: ['./new-details.component.css']
})
export class NewDetailsComponent implements OnInit {
  submitted=false;
  details: Details;
  formDetails: Student[];
  
  selectedyear: string;
  years: number[];
   batches:string[];
   tests:Tests;
   report:IReport[];
  createAccountForm: FormGroup;
  

  
  
  constructor(private reportservice:ReportService, private toastr: ToastrService ) {
    this.details=new Details();
   }

  ngOnInit(){
    this.reportservice.getyear().subscribe(data => {this.years=data;
      console.log(this.years)});

  
  this.createAccountForm = new FormGroup({
    years: new FormControl(''),
    batches: new FormControl(''),
    tests: new FormControl('')
  });
  }
  onChangeYear(name: number) {
    console.log(this.selectedyear);
    this.details.year=name;
    if (name) {
      this.reportservice.getbatches(name).subscribe(data => {this.batches=data;
         console.log(this.batches)});
        }
        else {
      this.batches = null;
      this.tests = null;
    }
  }

  onChangeBatch(bname: string) {
    this.details.batchName=bname;
    console.log(bname)
    if (bname) {
      this.reportservice.gettests(bname).subscribe(data => {this.tests=data;
        console.log(this.tests)});
      }
       else {
      this.tests = null;
    }
  }

  onChangeTest(tname: string){
    this.details.testName=tname;
  }
 
onSubmit(){
  this.submitted = true;
  console.log(this.submitted);
  
  this.details.successPercentage=(this.details.correctQuestions*100)/this.details.totalQuestions;
  console.log(this.details);
 

  this.reportservice.addNewDetails(this.details)
        .subscribe(data =>{
          this.details = data;
          alert("Submitted successfully");
        },err=>
          {
            alert("Error in creating entry.")
          });
  
}
  
onChangeId(id: number){
  this.reportservice.getDetailsinForm(id)
        .subscribe(data =>{
          this.formDetails = data;
          console.log("here:", this.formDetails);
          if(this.formDetails== null)
      {
        this.toastr.error('error','No record found for this input');
        alert('No such data present');
      }
    
          
        });

}
    

}
