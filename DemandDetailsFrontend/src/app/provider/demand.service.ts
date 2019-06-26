import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DemandService {

  constructor(private http: HttpClient) { }

  private demandsUrl = 'http://localhost:8080/DemandDetails/api/hiringDetails';

  /** GET heroes from the server */
getDemands () {
  return this.http.get(this.demandsUrl)
}
}
