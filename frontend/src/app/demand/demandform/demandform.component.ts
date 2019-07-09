import { Component, OnInit } from '@angular/core';
import { Demand } from 'src/app/demand/model/hiring';
import { DemandService } from 'src/app/demand/provider/demand.service';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-demandform',
    templateUrl: './demandform.component.html',
    styleUrls: ['./demandform.component.css']
})

export class DemandformComponent implements OnInit {
    demandModel: Demand = new Demand(
    );
    employees: any = {};
    locations: any = {};
    popup = false;

    settings = {
        bigBanner: false,
        timePicker: false,
        format: 'dd-MM-yyyy',
        defaultOpen: false,
        closeOnSelect: false
    }

    constructor(private demandService: DemandService, private toastrService: ToastrService) {
        demandService.loadData();
        this.employees = demandService.getEmployees();
        this.locations = demandService.getLocations();
        console.log(this.employees);
    }
    ngOnInit() {
    }
    onSubmitForm() {
        this.demandService.insertDemand(this.demandModel).subscribe(data => {
            console.log(data);
            this.printSuccess();

            this.demandModel = new Demand();
        },
            error => { this.printFailure(); }
        );

    }
    printSuccess() {
        this.toastrService.success('success', 'Demand Added');
    }
    printFailure() {
        this.toastrService.error('Error', 'Fill Valid details!');
    }

}
