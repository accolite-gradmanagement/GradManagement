import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-frontpage',
  templateUrl: './frontpage.component.html',
  styleUrls: ['./frontpage.component.scss']
})
export class FrontpageComponent implements OnInit {

  private loggedInStatus=JSON.parse(localStorage.getItem('loggedIn')||'false');
  constructor(private router : Router) {
    if(this.loggedInStatus)
    {
      this.router.navigate(['home']);
    }

   }

  ngOnInit() {
  }

}
