import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {ReportService} from '../report.service';
import { Student } from '../student';
@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  contents:Student[];
  constructor(private reportService: ReportService,
    private route:ActivatedRoute) { }

  ngOnInit() {
   this.getDetails();
  }
  getDetails(){
    const id = +this.route.snapshot.paramMap.get('id');
    this.reportService.getStudentDetails(id)
      .subscribe(data=> this.contents = data);

      console.log(this.contents);
  }

}
