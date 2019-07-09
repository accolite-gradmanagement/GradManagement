import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Demand, Employee } from '../model/hiring';


@Injectable({
    providedIn: 'root'
})
export class DemandService {
    private _url="";
    private demandsUrl = 'DemandDetails/api/hiringDetails';
    employeesUrl = 'DemandDetails/api/employees';
    locationsUrl = 'DemandDetails/api/locations';
    insertDemandUrl = 'DemandDetails/api/hiringDetails';
    insertEmployeeUrl = 'DemandDetails/api/employee';
    employees: any = {};
    locations: any = {};
    constructor(private http: HttpClient) {
        this.loadData();

    }

    loadData() {
        this.http.get(this.employeesUrl).subscribe(response => {
            for (const index in response) {
                const employee = response[index];
                this.employees[employee['empId']] = employee;
            }
            console.log(this.employees);
        });

        this.http.get(this.locationsUrl).subscribe(response => {
            for (const index in response) {
                const location = response[index];
                this.locations[location['location_ID']] = location;
            }
            console.log(this.locations);
        });
    }

    getLocations() {
        return this.locations;
    }

    getEmployees() {
        return this.employees;
    }

    getDemands() {
        return this.http.get(this.demandsUrl);
    }

    insertDemand(demand: Demand) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            })
        };
        const newDemand = { ...demand };
        newDemand.edId = Number(newDemand.edId);
        newDemand.hmId = Number(newDemand.hmId);
        newDemand.demandCount = Number(newDemand.demandCount);
        newDemand.lId = Number(newDemand.lId);
        newDemand.startTime = new Date(newDemand.startTime);
        newDemand.status = 'NOT SATISFIED';
        console.log(newDemand);
        return this.http.post(this.insertDemandUrl, newDemand
            , httpOptions);
    }

    addEmployee(empModel: Employee) {
        const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type': 'application/json',
            })
        };
        return this.http.post(this.insertEmployeeUrl, empModel, httpOptions);
    }
}
