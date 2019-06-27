import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DemandService {
  
  private demandsUrl = 'DemandDetails/api/hiringDetails';
  employeesUrl = 'DemandDetails/api/employees';
  locationsUrl = 'DemandDetails/api/locations'

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
        this.locations[location['location_ID']] = location;
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
}
