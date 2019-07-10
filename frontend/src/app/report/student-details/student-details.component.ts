import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReportService } from '../../report.service';
import { Student } from '../../student';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  istable: boolean=false;
  nameSearch: string;
  contents:Student[];
  private isLoaded:boolean=false;
  constructor(private reportService: ReportService,

    private route:ActivatedRoute) { }

  ngOnInit() {
  const id = this.route.snapshot.paramMap.get('id');
  const name = this.route.snapshot.paramMap.get('name');
  console.log(id);
  console.log(name);
  this.isLoaded=false;
  if(id)
  {
    this.getDetails(id);
    this.istable=true;
  }
  
   
/*   this.getDetails(id);
 */   
}
getDetails(id:string){
  
  this.reportService.getDetails(id)
    .subscribe(data=> {this.contents = data
      console.log(this.contents);
      this.isLoaded=true;
      
    });

    
}


  onSearch()
{
  this.reportService.getStudentDetailsbyName(this.nameSearch).subscribe(data=>
    {
      if(data.length==0)
      {
        //this.toastr.error("No record for this data ");
        alert('No such data present');
      }
      else
      {
        // this.router.navigate(["score/detail/name",this.nameSearch]);
        this.contents = data;
        console.log(this.contents);
        this.isLoaded=true; 
        this.istable=true;
      }
    });
    
}

}
