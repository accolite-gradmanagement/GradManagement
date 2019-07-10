import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ReportService } from '../../report.service';
import {IReport} from '../../IReport';
import{Tests} from '../../Tests';
import {Router} from '@angular/router'
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-front',
  templateUrl: './front.component.html',
  styleUrls: ['./front.component.css']
})
export class FrontComponent implements OnInit {
  nameSearch: string;
  selectedyear: string = "Select year...";
  selectedbatch: string ="Select batch...";
  selectedtest: string ="Select test...";
  years: number[];
  batches:string[];
  tests:Tests[];
  report:IReport[];
  createAccountForm: FormGroup;

  constructor(private reportservice:ReportService,private router:Router ,private toastr: ToastrService ) { }
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
  console.log(name)
  if (name) {
    this.reportservice.getbatches(name).subscribe(data => {
       this.batches=data;
       console.log(this.batches)});
      //  this.onChangeBatch(this.batches[0]);
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


myfunc(){
  let selectedlist = "/scores/"+Number(this.selectedyear)+"/"+this.selectedbatch+"/"+this.selectedtest;
  console.log(this.selectedyear + this.selectedbatch + this.selectedtest);
  this.reportservice.getList(selectedlist).subscribe(data => {this.report=data;
    
    console.log(this.report)});
    this.selectedyear="Select year...";
    this.selectedbatch="Select batch...";
    this.selectedtest="Select test...";

    // if(this.report==null){
    //   alert("No details to show");
    // }

}
onSearch()
{
  this.reportservice.getStudentDetailsbyName(this.nameSearch).subscribe(data=>
    {
      if(data.length==0)
      {
        //this.toastr.error("No record for this data ");
        alert('No such data present');
      }
      else
      {
        this.router.navigate(["score/detail/name",this.nameSearch]);
      }
    });
    this.selectedyear="Select year...";
    this.selectedbatch="Select batch...";
    this.selectedtest="Select test...";
}

sample(){
  this.selectedyear="Select year...";
  this.selectedbatch="Select batch...";
  this.selectedtest="Select test...";

}

}