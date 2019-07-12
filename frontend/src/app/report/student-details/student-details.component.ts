import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReportService } from '../../report.service';
import { Student } from '../../student';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  gridApi :any;
  columnApi: any;
  columnDefs = [
    {headerName: 'TestId', field: 'score_id', resizable: true },
    {headerName: 'Test Name', field: 'gradTest.testName' , resizable: true},
    {headerName: 'Score', field: 'score', resizable: true},
    {headerName: 'Rank', field: 'gradRank', resizable: true}
   ];
   rowData: Student[];
  //  onGridReady(params)
  //  {
  //   this.columnApi=params.columnApi;
  //   this.gridApi=params.api;
  //   params.api.sizeColumnsToFit()
    
  //  }

  istable: boolean=false;
  nameSearch: string;
  contents:Student[];
  private isLoaded:boolean=false;
  constructor(private reportService: ReportService,

    private route:ActivatedRoute,private http: HttpClient) { }

  ngOnInit() {
  this.istable=false;
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
    .subscribe(data=> {this.rowData = data
      console.log(this.rowData);
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
        this.rowData = data;
        console.log(this.rowData);
        this.isLoaded=true; 
        this.istable=true;
      }
    });
    
}
onBack()
{
  if(this.istable)
  {
    this.istable=false;
  }
}

}
