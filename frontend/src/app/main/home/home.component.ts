import { Component, OnInit } from '@angular/core';
import { RouterLink, Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  private loggedInStatus=JSON.parse(sessionStorage.getItem('loggedIn')||'false');
  grad=false;
  admin=false;
  trainer=false;

  constructor(private router:Router) {  
  
    document.body.style.backgroundImage = null;
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

  // logout()
  // {
  //   sessionStorage.clear();
  //   this.router.navigate(['/front']);
  // }
}
