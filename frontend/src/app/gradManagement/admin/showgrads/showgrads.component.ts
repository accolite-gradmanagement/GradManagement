import { Component, OnInit } from "@angular/core";
import { Grad } from 'src/app/gradManagement/gradmanagement/Grad';
import { GradService } from 'src/app/grad.service';
import { MatDialog } from '@angular/material';
import { ConfirmationDialogComponent } from 'src/app/gradManagement/confirmation-dialog/confirmation-dialog.component';
import {Sort} from '@angular/material/sort';
import { MyLinkRendererComponent } from './my-link-renderer.component';

@Component({
  selector: "app-showgrads",
  templateUrl: "./showgrads.component.html",
  styleUrls: ["./showgrads.component.scss"]
})
export class ShowgradsComponent implements OnInit {

  constructor(private gradService: GradService,public dialog: MatDialog,) { 
    
  }

  emailRenderer =  function(params) {
    return `<a href="mailto:${params.value}">${params.value}</a>`
  }

  linkRenderer =  function(params) {
    return `<a href="${params.value}">${params.value}</a>`
  }

  columnDefs = [
    {
      headerName: "Employee Code", field: "employeeCode", 
      sortable:true, filter:true, comparator:empComparator,
      cellRendererFramework: MyLinkRendererComponent,
      cellRendererParams: {
        inRouterLink: "/grads",
      }
    },
    {headerName: "Name", field: "name", sortable:true, filter:true},
    {
      headerName: "Email", field: "email", filter:true,
      cellRenderer: this.emailRenderer
    },
    {headerName: "College", field: "college", filter:true},
    {headerName: "Location", field: "location", filter:true},
    {headerName: "Date of Joining", field: "dateOfJoining", sortable:true, filter:true},
    {headerName: "Batch", field: "batch", filter:true},
    {headerName: "Date of Joining Reconfirmation", field: "dateOfJoiningReconfirmation", filter:true},
    {headerName: "Remarks", field: "remarks"},
    {headerName: "Course", field: "course", filter:true},
    {headerName: "Branch", field: "branch", filter:true},
    {headerName: "Current CGPA", field: "cgpa", sortable:true},
    {headerName: "Personal Number", field: "personalNumber"},
    {
      headerName: "Personal Email", field: "personalEmail",
      cellRenderer: this.emailRenderer
    },
    {headerName: "Date of Birth", field: "dob", sortable:true},
    {headerName: "Native Place", field: "nativePlace"},
    {headerName: "Current Place", field: "currentPlace", filter:true},
    {headerName: "Parent Contact", field: "parentContact"},
    {headerName: "Parent Address", field: "parentAddress"},
    {
      headerName: "CV", field: "cvLink",
      cellRenderer: this.linkRenderer
    },
  ]

  // searchText = '';
  nameSearch = '';
  empCodeSearch ='';
  sortedGrads: Grad[];
  rowData: Grad[];
  multiSortKey = "ctrl";

  ngOnInit() {
    this.reloadData();
    // while(this.grads == null){
    //   console.log("not filled yet");
    // }
  }

  reloadData() {
    this.gradService.getGradsList()
      .subscribe(data => this.rowData = data._embedded.gradList);
  }

  deleteGrad(id: number) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '390px',
      disableClose: true,
      data: "Do you really want to delete... ?"
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log('Yes clicked');
        this.gradService.deleteGrad(id)
          .subscribe(
            data => {
              console.log(data);
              this.reloadData();
            },
            error => console.log(error));
      }
    });

  }

  sortData(sort: Sort) {
    const data = this.sortedGrads.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedGrads = data;
      return;
    }

    this.sortedGrads = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'Employee Code': return compareEmp(a.employeeCode, b.employeeCode, isAsc);
        case 'Name': return compare(a.name, b.name, isAsc);
        case 'College': return compare(a.college, b.college, isAsc);
        case 'Location': return compare(a.location, b.location, isAsc);
        case 'Date of Joining': return compare(a.joiningDate, b.joiningDate, isAsc);
        case 'CGPA': return compare(a.cgpa, b.cgpa, isAsc);
        case 'DoB': return compare(a.dob, b.dob, isAsc);
        case 'Current Place': return compare(a.currentPlace, b.currentPlace, isAsc);
        default: return 0;
      }
    });
  }

}

function compare(a: number | string | Date, b: number | string | Date, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

function compareEmp(a:string, b:string, isAsc: boolean) {
  var emp1 = parseInt(a);
  var emp2 = parseInt(b);
  return (emp1 - emp2) * (isAsc ? 1 : -1);
}

function empComparator(a:string, b:string) {
  var emp1 = parseInt(a);
  var emp2 = parseInt(b);
  return (emp1 - emp2);
}

