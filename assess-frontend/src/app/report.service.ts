import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, from} from 'rxjs';
//import {IYear} from './IYear';
import {IReport} from './IReport';

@Injectable({
  providedIn: 'root'
})
export class ReportService {
  private url: string= "/assets/report.json";
 // private url2: string= "/assets/data/Student.json";


 
  constructor(private http: HttpClient) { }

  // public getList():Observable<IReport[]>{
  //   return this.http.get<IReport []>(this.url);
  // }

  public getList(somelist:string):Observable<IReport[]>{
    return this.http.get<IReport []>(somelist);
  }

  // public getScoreList(){
  //     return this.http.get(this.url2);
  // }
//   let params = new HttpParams()
//   .set('selectedyear', "1999")
//   .set('selectedbatch', "Batch")
//   .set('selectedtest', "Test");

// // JSON.stringify(sas);
// let url = 'avjvchvcdvc/acghdyc/'

// return this.http.post<IReport[]>(url, params.toString(), httpOptions);

  }
