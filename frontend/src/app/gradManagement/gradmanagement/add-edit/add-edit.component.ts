import { Component, OnInit } from '@angular/core';
import { GradService } from 'src/app/grad.service';
import { Grad } from '../Grad';
import { ParamMap, ActivatedRoute, Router } from '@angular/router';
import { DatePicker } from 'angular2-datetimepicker';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.scss']
})
export class AddEditComponent implements OnInit {
  private loggedInStatus = JSON.parse(localStorage.getItem('loggedIn') || 'false');
  gradRole = false;
  adminRole = false;
  trainerRole = false;

  grad: Grad;
  gradId: number;
  submitted = false;

  settings = {
    bigBanner: false,
    timePicker: false,
    format: 'dd/mm/yyyy',
    defaultOpen: false,
    closeOnSelect: true,
}

  constructor(private gradService: GradService, private route: ActivatedRoute, private router: Router) {
    this.grad = new Grad();
    console.log("from add edit: " + JSON.stringify(sessionStorage));
    DatePicker.prototype.ngOnInit = function() {
      // this.settings = Object.assign(this.defaultSettings, this.settings);
      this.date = new Date();
      }
  }

  ngOnInit() {
    //checking the role of the user i.e.either grad or admin or trainer
    const role = this.loggedInStatus.role;
    if (role == "grad")
      this.gradRole = true;
    else if (role == "admin")
      this.adminRole = true;
    else
      this.trainerRole = true;

    this.route.paramMap.subscribe((params: ParamMap) => {
      this.gradId = parseInt(params.get('id'));
    });
    if (this.gradId)
      this.route.queryParams.subscribe(params => {
        this.grad = JSON.parse(params.grad);
      });
  }

  // newGrad(): void {
  //   this.submitted = false;
  //   this.grad = new Grad();
  // }

  save() {
    if (this.gradId) {
      this.gradService.updateGrad(this.gradId, this.grad)
        .subscribe(data => this.grad = data, error => console.log(error));
    }
    else {
      this.gradService.createGrad(this.grad)
        .subscribe(data => this.grad = data, error => console.log(error));
        this.gradId=this.grad.id;
    }
    if (this.grad.id)
      this.router.navigate(["/grads", this.gradId]);
    //this.grad = new Grad();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  onCancelClick() {
    if (this.grad.id)
      this.router.navigate(["/grads", this.grad.id]);

  }
}
