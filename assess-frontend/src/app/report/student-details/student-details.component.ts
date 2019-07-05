import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {ReportService} from '../../report.service';
import { Student } from '../../student';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  contents:Student[];
  constructor(private reportService: ReportService,
    private route:ActivatedRoute) { }

  ngOnInit() {
  const id = this.route.snapshot.paramMap.get('id');
  const name = this.route.snapshot.paramMap.get('name');
  console.log(id);
  console.log(name);
  if(id)
  {
    this.getDetails(id);
  }
  else 
  {
    this.getDetailsbyName(name);
  }
   
   
  }
  getDetails(id:string){
    
    this.reportService.getStudentDetails(id)
      .subscribe(data=> this.contents = data);

      console.log(this.contents);
  }
  getDetailsbyName(name:string){
    
    this.reportService.getStudentDetailsbyName(name)
    .subscribe(data=> this.contents = data);
  //   if(this.contents==null) { alert("Employee doesnt exist");
  // }
    console.log(this.contents);
  }

}
