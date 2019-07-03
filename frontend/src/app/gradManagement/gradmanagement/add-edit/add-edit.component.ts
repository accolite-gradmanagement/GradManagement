import { Component, OnInit } from '@angular/core';
import { GradService } from 'src/app/grad.service';
import { Grad } from '../Grad';
import { ParamMap, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-edit',
  templateUrl: './add-edit.component.html',
  styleUrls: ['./add-edit.component.css']
})
export class AddEditComponent implements OnInit {
  private loggedInStatus = JSON.parse(sessionStorage.getItem('loggedIn') || 'false');
  gradRole = false;
  adminRole = true;
  trainerRole = false;

  grad: Grad;
  gradId: number;
  submitted = false;

  constructor(private gradService: GradService, private route: ActivatedRoute, private router: Router) {
    this.grad = new Grad();
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
    }
    this.router.navigate(["/grads", this.grad.id])
    //this.grad = new Grad();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
