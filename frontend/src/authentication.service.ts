import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private url : string="http://localhost:8080/msgrad/getAll";
  constructor(private http: HttpClient) { }

  getLoginCredentials()
  {
    return this.http.get(this.url);
  }

  

}
