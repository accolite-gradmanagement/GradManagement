import { Component, OnInit } from '@angular/core';
import { DemandService } from '../../provider/demand.service'

@Component({
  selector: 'app-demanddetails',
  templateUrl: './demanddetails.component.html',
  styleUrls: ['./demanddetails.component.css']
})
export class DemanddetailsComponent implements OnInit {

  data = [
    {ename:'sathish', hname:'sathish', location:'Mumbai', demand_count:3, start_time:"", comments: 'hdgjf'},
    {ename:'sathish', hname:'sathish', location:'Bangalore', demand_count:4, start_time:"", comments: 'dagv'},
    {ename:'sathish', hname:'praveen', location:'Bangalore', demand_count:2, start_time:"", comments: ''},
    {ename:'sathish', hname:'sathish', location:'Mumbai', demand_count:3, start_time:"", comments: 'hdgjf'},
    {ename:'sathish', hname:'sathish', location:'Bangalore', demand_count:4, start_time:"", comments: 'dagv'},
    {ename:'sathish', hname:'praveen', location:'Bangalore', demand_count:2, start_time:"", comments: ''},
    {ename:'mohit', hname:'sai', location:'Mumbai', demand_count:5, start_time:"", comments: ''},
    {ename:'mohit', hname:'sai', location:'Bangalore', demand_count:5, start_time:"", comments: 'beqjgf'},
    {ename:'mohit', hname:'sai', location:'Mumbai', demand_count:5, start_time:"", comments: ''},
    {ename:'mohit', hname:'sai', location:'Bangalore', demand_count:5, start_time:"", comments: 'beqjgf'},
    {ename:'praveen', hname:'sathish', location:'Mumbai', demand_count:4, start_time:"", comments: ''},
    {ename:'sai', hname:'mohit', location:'Mumbai', demand_count:5, start_time:"", comments: ''},
    {ename:'sai', hname:'praveen', location:'Bangalore', demand_count:3, start_time:"", comments: 'fhgwjg'},
    {ename:'srujan', hname:'srujan', location:'Mumbai', demand_count:3, start_time:"", comments: ''},
    {ename:'srujan', hname:'srujan', location:'Bangalore', demand_count:2, start_time:"", comments: ''}
  ]
  
  formattedData= {};
  isViewableArray = {};
  isViewable = true;

  constructor(private service: DemandService) {
    
    this.service.getDemands().subscribe(demands => {console.log(demands)});
    
    let hm1 = [];
    for(let i in this.data) {
      let tempObj = this.data[i];
      let edObj = this.formattedData[tempObj['ename']];
      if(edObj == undefined) {
        edObj = {};
      }
      let hmObj=edObj[tempObj['hname']];
      if(hmObj == undefined) {
        hmObj = [];
      } 
      let demandObject = this.getFormattedDemandObject(tempObj);
      hmObj.push(demandObject);
      edObj[tempObj['hname']] = hmObj;
      this.formattedData[tempObj['ename']] = edObj;
      this.isViewableArray[tempObj['ename']] = true;
    }
    console.log(this.isViewableArray);  
  }

  ngOnInit() {
    
  
  }

  
  getFormattedDemandObject(demand: any) {
      let demandObject = {};
      demandObject['location'] = demand['location'];
      demandObject['demand_count'] = demand['demand_count'];
      demandObject['start_time'] = demand['start_time'];
      return demandObject;
  }


  toggle(edName){
    this.isViewableArray[edName] = !this.isViewableArray[edName];
    // this.isViewable= !this.isViewable;

  }

}
