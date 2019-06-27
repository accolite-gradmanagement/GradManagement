import { Component, OnInit } from '@angular/core';
import { DemandService } from '../../provider/demand.service'

@Component({
  selector: 'app-demanddetails',
  templateUrl: './demanddetails.component.html',
  styleUrls: ['./demanddetails.component.css']
})
export class DemanddetailsComponent implements OnInit {

  // data = [
  //   {ename:'sathish', hname:'sathish', location:'Mumbai', demand_count:3, start_time:"", comments: 'hdgjf'},
  //   {ename:'sathish', hname:'sathish', location:'Bangalore', demand_count:4, start_time:"", comments: 'dagv'},
  //   {ename:'sathish', hname:'praveen', location:'Bangalore', demand_count:2, start_time:"", comments: ''},
  //   {ename:'sathish', hname:'sathish', location:'Mumbai', demand_count:3, start_time:"", comments: 'hdgjf'},
  //   {ename:'sathish', hname:'sathish', location:'Bangalore', demand_count:4, start_time:"", comments: 'dagv'},
  //   {ename:'sathish', hname:'praveen', location:'Bangalore', demand_count:2, start_time:"", comments: ''},
  //   {ename:'mohit', hname:'sai', location:'Mumbai', demand_count:5, start_time:"", comments: ''},
  //   {ename:'mohit', hname:'sai', location:'Bangalore', demand_count:5, start_time:"", comments: 'beqjgf'},
  //   {ename:'mohit', hname:'sai', location:'Mumbai', demand_count:5, start_time:"", comments: ''},
  //   {ename:'mohit', hname:'sai', location:'Bangalore', demand_count:5, start_time:"", comments: 'beqjgf'},
  //   {ename:'praveen', hname:'sathish', location:'Mumbai', demand_count:4, start_time:"", comments: ''},
  //   {ename:'sai', hname:'mohit', location:'Mumbai', demand_count:5, start_time:"", comments: ''},
  //   {ename:'sai', hname:'praveen', location:'Bangalore', demand_count:3, start_time:"", comments: 'fhgwjg'},
  //   {ename:'srujan', hname:'srujan', location:'Mumbai', demand_count:3, start_time:"", comments: ''},
  //   {ename:'srujan', hname:'srujan', location:'Bangalore', demand_count:2, start_time:"", comments: ''}
  // ]
  
  formattedData= {};
  isViewableArray = {};
  isViewable = true;

  constructor(private service: DemandService) {
    this.getDemands();
  }

  ngOnInit() {
    
  }
  getDemands() {
    this.service.getDemands().subscribe(demands => {
      console.log(demands);
      let employees =  this.service.getEmployees();
      let locations =  this.service.getLocations();  
      for(let i in demands) {
        let tempObj = demands[i];
        let edEmployee = employees[tempObj['ed_ID']];
        let edObj = this.formattedData[edEmployee.emp_NAME];
        if(edObj == undefined) {
          edObj = {};
        }
        let hmEmployee = employees[tempObj['hm_ID']]
        let hmObj=edObj[hmEmployee.emp_NAME];
        if(hmObj == undefined) {
          hmObj = [];
        } 
        let demandObject = this.getFormattedDemandObject(locations, tempObj);
        hmObj.push(demandObject);
        edObj[hmEmployee.emp_NAME] = hmObj;
        this.formattedData[edEmployee.emp_NAME] = edObj;
        this.isViewableArray[edEmployee.emp_NAME] = true;
      }
    });
    
  }
  getFormattedDemandObject(locations: any, demand: any) {
      let demandObject = {};
      let location = locations[demand['l_ID']];
      demandObject['location'] = location.location_NAME;
      demandObject['demand_count'] = demand['demand_COUNT'];
      demandObject['start_time'] = new Date(demand['start_TIME']).toLocaleDateString();
      demandObject['status']=demand['status'];
      return demandObject;
  }


  toggle(edName){
    this.isViewableArray[edName] = !this.isViewableArray[edName];
    // this.isViewable= !this.isViewable;

  }

  getTotalDemands(edObj){
    let total=0;
    for(let employee in edObj)
    {
        let hmObj=edObj[employee];
        for(let index in hmObj)
        {
          total+=hmObj[index].demand_count;
        }

    }
    return total;
    
  }

}
