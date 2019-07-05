import { Component, OnInit } from '@angular/core';
import { DemandService } from '../../provider/demand.service';

@Component({
    selector: 'app-demanddetails',
    templateUrl: './demanddetails.component.html',
    styleUrls: ['./demanddetails.component.css']
})
export class DemanddetailsComponent implements OnInit {

    formattedData = {};
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
            const employees = this.service.getEmployees();
            const locations = this.service.getLocations();
            for (const i in demands) {
                const tempObj = demands[i];
                const edEmployee = employees[tempObj['edId']];
                let edObj = this.formattedData[edEmployee.emp_NAME];
                if (edObj == undefined) {
                    edObj = {};
                }
                const hmEmployee = employees[tempObj['hmId']];
                let hmObj = edObj[hmEmployee.emp_NAME];
                if (hmObj == undefined) {
                    hmObj = [];
                }
                const demandObject = this.getFormattedDemandObject(locations, tempObj);
                hmObj.push(demandObject);
                edObj[hmEmployee.emp_NAME] = hmObj;
                this.formattedData[edEmployee.emp_NAME] = edObj;
                this.isViewableArray[edEmployee.emp_NAME] = true;
            }
        });

    }
    getFormattedDemandObject(locations: any, demand: any) {
        const demandObject = {};
        const location = locations[demand['lId']];
        demandObject['location'] = location.location_NAME;
        demandObject['demandCount'] = demand['demandCount'];
        demandObject['start_time'] = new Date(demand['startTime']).toLocaleDateString();
        demandObject['status'] = demand['status'];
        demandObject['comments'] = demand['comments'];
        return demandObject;
    }


    toggle(edName) {
        this.isViewableArray[edName] = !this.isViewableArray[edName];
        // this.isViewable= !this.isViewable;

    }

    getTotalDemands(edObj) {
        let total = 0;
        for (const employee in edObj) {
            const hmObj = edObj[employee];
            for (const index in hmObj) {
                total += hmObj[index].demandCount;
            }
        }
        return total;

    }

}
