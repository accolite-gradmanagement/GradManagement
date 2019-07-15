import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  nameSearch: string;
  constructor(private route:ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  onSearch(){
    this.router.navigate(["score/search/ename",this.nameSearch]);

  }

}
