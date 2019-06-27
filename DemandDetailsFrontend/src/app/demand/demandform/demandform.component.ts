import { Component, OnInit } from '@angular/core';
import { Demand } from 'src/app/model/hiring';
import { DemandService } from 'src/app/provider/demand.service';

@Component({
  selector: 'app-demandform',
  templateUrl: './demandform.component.html',
  styleUrls: ['./demandform.component.css']
})
export class DemandformComponent implements OnInit {
  demandModel: Demand=new Demand(
    0, '', 0, '', 0, 0, 0,'', ''
  );
  employees:any = {};
  locations: any = {};
  constructor(private demandService: DemandService) {
    this.employees =  demandService.getEmployees();
    this.locations = demandService.getLocations();
    console.log(this.employees);
  }
  ngOnInit() {
  }
  onSubmitForm() {
    this.demandService.insertDemand(this.demandModel).subscribe(data=>{
      console.log(data);
    }, 
    error => {console.log(error)}
    );

  }



}
