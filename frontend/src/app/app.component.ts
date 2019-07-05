import { Component } from '@angular/core';
import { setTheme } from 'ngx-bootstrap/utils';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'aums';
  private loggedInStatus=JSON.parse(sessionStorage.getItem('loggedIn')||'false');
  grad=false;
  admin=false;
  trainer=false;

  constructor(private router:Router) {  
    setTheme('bs3'); // or 'bs4'

    document.body.style.backgroundImage = null;
    // if(this.loggedInStatus==false)
    // {
    //   this.router.navigate(['login']);
    // }
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
    sessionStorage.clear();
    this.loggedInStatus = false;
    this.router.navigate(['/front']);
  }
}
