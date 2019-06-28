import { Component, OnInit } from '@angular/core';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent  {

  private loggedInStatus=JSON.parse(localStorage.getItem('loggedIn')||'false');
  grad=false;
  admin=false;
  trainer=false;

  constructor(private router:Router) {
    console.log(this.loggedInStatus);
    if(this.loggedInStatus==false)
    {
      this.router.navigate(['login']);
    }
  }

  ngOnInit() {
    
    const x=this.loggedInStatus.role;
    if(x=="grad")
      this.grad=true;
    else if(x=="admin")
    this.admin=true;
    else
    this.trainer=true;

    // // console.log(this.role);
  }

  logout()
  {
    localStorage.clear();
  }
 
}
