import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'


import { ReportService } from '../report.service';
import {IReport} from '../IReport';
import{Tests} from '../Tests';


@Component({
  selector: 'app-new-detail',
  templateUrl: './new-detail.component.html',
  styleUrls: ['./new-detail.component.css']
})
export class NewDetailComponent implements OnInit {

  employeeCode: number;
  name: string=" ";
  gradyear: number;
  gradbatch: string="";
  testname: string="";
  totalquestions: number;
  correctquestions: number;
  incorrectquestions: number;
  successperc: number;
  selectedyear: string = "Year";
  selectedbatch: string ="Batch";
  selectedtest: string ="Test";
  score: number;
  rank: number;
  //selectedlist: string = "/scores/"+Number(this.selectedyear)+"/"+this.selectedbatch+"/"+this.selectedtest;
 
  
  //  years:IYear[];
  years: number[];
   batches:string[];
   tests:Tests;
   report:IReport[];
  createAccountForm: FormGroup;
  //yearname: {};
  //batchname: {};
  //testname: {};

  
  
  constructor(private reportservice:ReportService ) { }
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
    console.log(name)
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
    console.log(bname)
    if (bname) {
      this.reportservice.gettests(bname).subscribe(data => {this.tests=data;
        console.log(this.tests)});
      }
       else {
      this.tests = null;
    }
  }
 
onSubmit(){

  
}
  
    

}
