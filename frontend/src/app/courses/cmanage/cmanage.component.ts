import { Component, OnInit } from '@angular/core';
// import { FormControl, FormGroup} from '@angular/forms';
import { FormGroup, FormArray, FormBuilder, Validators } from '@angular/forms';
import { SharedService } from '../../shared.service';
import { Course } from './interfaces_req';
import { element } from 'protractor';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-cmanage',
  templateUrl: './cmanage.component.html',
  styleUrls: ['./cmanage.component.css']
})
export class CmanageComponent implements OnInit {

  courseList: Course[] = [];
  courseObj: Course = new Course(null,null);
  courseName: string = null;
  alreadyPresent = false;
  toDelete: boolean = true;
  constructor(public toastr: ToastrService,private fb: FormBuilder, private service: SharedService) { }

  ngOnInit() {
    this.service.getCourses().subscribe(data => {
      this.courseList = data;
    });
  }

  deleteCourse(cid: number) {
    this.service.deleteCourse(cid).subscribe(data => {
      this.ngOnInit();
      // alert("Deleted Successfully");
      this.toastr.success("Deleted successfully...","Success!!");
    },err=>{
      // alert("Course is associated with Trainer. Cant Delete the Course");
      this.toastr.error("Course is associated with Trainer... Cant Delete the Course","Error!!");

      // alert("Course Associated with Trainer.Can't Delete Course");    
    });
  }

  submit() {

    this.courseObj.course_id = null;
    this.courseObj.course_name = this.courseName;
      this.service.addCourse(this.courseObj).subscribe(data => {
        this.ngOnInit();
        this.courseName = "";
        alert("Submitted successfully");
        this.toastr.success("Submitted successfully...","Success!!");
      },err=>
      {
        this.toastr.error("Tried to add Duplicate Course","Error!!");
        // alert("Duplicate Course");
        this.courseName='';
      });



  }

}