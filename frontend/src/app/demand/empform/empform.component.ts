import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/demand/model/hiring';
import { DemandService } from 'src/app/demand/provider/demand.service';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-empform',
    templateUrl: './empform.component.html',
    styleUrls: ['./empform.component.css']
})
export class EmpformComponent implements OnInit {
    empModel: Employee = new Employee();
    constructor(private demandService: DemandService, private toastrService: ToastrService) { }

    ngOnInit() {
    }
    onSubmitForm() {
        if (!isNaN(this.empModel.empId)) {

            this.empModel.empId = Number(this.empModel.empId);
            this.demandService.addEmployee(this.empModel).subscribe(response => {
                this.empModel = new Employee();
                this.printSuccess();
            }, error => {
                this.printFailure(error);
            });
        } else {
            this.printFailure('  ID should be a number');
        }

    }

    printSuccess() {
        this.toastrService.success('success', 'Employee Added');
    }
    printFailure(error) {
        this.toastrService.error('Error', 'Fill Valid details/Server Error!' + error);
    }
}
