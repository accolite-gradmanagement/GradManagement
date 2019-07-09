import { Grad } from '../Grad';
import { Component, OnInit} from '@angular/core';
import { GradService } from 'src/app/grad.service';
import { ActivatedRoute, Router, ParamMap, NavigationExtras } from '@angular/router';

@Component({
  selector: 'app-grad-details',
  templateUrl: './grad-details.component.html',
  styleUrls: ['./grad-details.component.scss']
})
export class GradDetailsComponent implements OnInit {
  private loggedInStatus = JSON.parse(localStorage.getItem('loggedIn') || 'false');
  gradRole = false;
  adminRole = false;
  trainerRole = false;
    gradId: number;
    graduate: Grad;
    isLoaded: boolean = false;
  
    constructor(private gradService: GradService, private route:ActivatedRoute,private router:Router) { 
    }
  
    ngOnInit() {
      const role = this.loggedInStatus.role;
      if (role == "grad")
        this.gradRole = true;
      else if (role == "admin")
        this.adminRole = true;
      else
        this.trainerRole = true;
      console.log("Init called");
      this.route.paramMap.subscribe((params: ParamMap)=>
      {
        this.gradId=parseInt(params.get('id'));
        this.gradService.getGrad(this.gradId).subscribe(data => this.graduate = data);
     
        if(this.graduate!=null)
          this.isLoaded=true;
      });   
    }

    updateGrad(){
      let navigationExtras: NavigationExtras = {
        queryParams: {
          grad: JSON.stringify(this.graduate)
        }
      };
      this.gradId = this.graduate.id;
      this.graduate = null;
      this.router.navigate(["/grads/fill", this.gradId], navigationExtras);
    }
  }
  