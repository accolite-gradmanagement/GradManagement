import { Component, OnInit } from '@angular/core';
import { FormGroup, FormArray, FormBuilder, Validators, NgForm } from '@angular/forms';
import { SharedService } from 'src/app/shared.service';
import { Course, Trainer } from '../cmanage/interfaces_req';
import { Query } from '@syncfusion/ej2-data';
import { EmitType } from '@syncfusion/ej2-base';
import { FilteringEventArgs } from '@syncfusion/ej2-dropdowns';
import { __values } from 'tslib';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-tmanage',
  templateUrl: './tmanage.component.html',
  styleUrls: ['./tmanage.component.css']
})
export class TmanageComponent implements OnInit {

  courses: any[];
  trainers:Trainer[];
  trainerName:string='';
  selectedCourses:any[]=[];
  courseNewArray:Course[]=[];
  trainer:Trainer;
  sel:any=[];
  public value: number[] = [];

  
  constructor(private toastr: ToastrService,private fb: FormBuilder, private service: SharedService) { }
  ngOnInit() {
    this.service.getCourses().subscribe(data=>{this.courses=data;
    });
    
    this.service.getTrainers().subscribe(data => {
    this.trainers= data;  
  }); 
 
}

onSubmit(form: NgForm): void {
  console.log(form.value.name);
  form.value.name.forEach(id=>
    {
      this.courses.forEach(element=>
        {
          if(id==element.course_id)
          {
            this.courseNewArray.push(element);
          }
        })
    });
    console.log("coursenewarray"+this.courseNewArray);
    this.trainer=new Trainer(this.trainerName,this.courseNewArray);
    this.service.sendTrainer(this.trainer).subscribe(data => {
      this.courseNewArray=[];
      this.ngOnInit();
      this.trainerName="";
      this.value=[];
      this.toastr.success("Submitted successfully","Success!!");
    },err=>
    {
      this.toastr.warning("Tried to add Duplicate Trainer","Error!!");
      this.trainerName='';
      this.value=[];
    });


}

deleteTrainer(tid: number) {
  this.service.deleteTrainer(tid).subscribe(data => {
    this.ngOnInit();
    this.toastr.success("Deleted successfully","Success!!");
 
  },err=>
  {
    this.toastr.warning("Trainer is already allocated in timesheet","Warning!!");
  });
}



public query: Query = new Query();
// maps the appropriate column to fields property
public fields: Object = { text: 'course_name', value: 'course_id' };
public watermarks: string = 'Select courses';
// filtering event handler to filter a country
public onFiltering: EmitType<FilteringEventArgs> = (e: FilteringEventArgs) => {
  
    console.log(this.sel);
    let query: Query = new Query();
    //frame the query based on search string with filter type.
    query = (e.text !== '') ? query.where('course_name', 'startswith', e.text, true) : query;
    //pass the filter data source, filter query to updateData method.
    e.updateData(this.courses, query);
    
};



  submit(arr:any,trainerName:string){
    // arr.forEach(element => {
    //   this.courseNewArray.push(this.courses[element]);
    // });    
    this.trainer=new Trainer(trainerName,this.courseNewArray);
    this.service.sendTrainer(this.trainer).subscribe(data => {
      console.log(data);
      this.ngOnInit();
    alert("Submitted successfully");
    },err=>
    {
      alert("Duplicate Trainer.Can't Add.")
    });
    
  }
}
