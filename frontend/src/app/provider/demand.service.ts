import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Demand } from '../model/hiring';


@Injectable({
  providedIn: 'root'
})
export class DemandService {
  
  private demandsUrl = 'DemandDetails/api/hiringDetails';
  employeesUrl = 'DemandDetails/api/employees';
  locationsUrl = 'DemandDetails/api/locations';
  insertDemandUrl = 'DemandDetails/api/hiringDetails';

  employees: any = {};
  locations: any = {};
  constructor(private http: HttpClient) { 
    this.http.get(this.employeesUrl).subscribe (response =>{ 
      for (let index in response) {
        let employee = response[index];
        this.employees[employee['emp_ID']] = employee;
      }
      console.log(this.employees);
    });

    this.http.get(this.locationsUrl).subscribe(response =>{
      for(let index in response) {
        let location = response[index];
        this.locations[location['location_ID']] = location
        ;
      }
      console.log(this.locations);
    })

  }
  getLocations() {
    return this.locations;   
  }
  getEmployees() {
    return this.employees;
  }
  getDemands () {
    return this.http.get(this.demandsUrl)
  }
  insertDemand(demand: Demand) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    let newDemand = {...demand};
    newDemand.edId = Number(newDemand.edId);
    newDemand.hmId = Number(newDemand.hmId);
    newDemand.demandCount = Number(newDemand.demandCount);
    newDemand.lId = Number(newDemand.lId);
    newDemand.startTime =  new Date();//1561746600000;
    newDemand.status = 'NOT SATISFIED';
    console.log(newDemand);
    return this.http.post(this.insertDemandUrl, newDemand
    , httpOptions);
  }
}
