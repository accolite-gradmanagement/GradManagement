import { Component, OnInit } from '@angular/core';
import { ReportService } from '../../report.service';
import { FormGroup, FormControl } from '@angular/forms'
import {IReport} from '../../IReport';
import{Tests} from '../../Tests';
import {Details} from '../../details';

@Component({
  selector: 'app-new-details',
  templateUrl: './new-details.component.html',
  styleUrls: ['./new-details.component.css']
})
export class NewDetailsComponent implements OnInit {
  submitted=false;
  details: Details;
  
  selectedyear: string;
  years: number[];
   batches:string[];
   tests:Tests;
   report:IReport[];
  createAccountForm: FormGroup;
  

  
  
  constructor(private reportservice:ReportService ) {
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
  console.log(this.details);
 

  this.reportservice.addNewDetails(this.details)
        .subscribe(data => this.details = data);
  
}
  
    

}
