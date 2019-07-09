import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, from} from 'rxjs';
import {IYear} from './IYear';
import {IReport} from './IReport';
import { Batch } from './batch';
import { Tests } from './Tests';
import { Student } from './student';
import { Details } from './details';
import {Employee} from './employee';

@Injectable({
  providedIn:'root'
})

export class ReportService {
  private url: string= "/assets/test.json";
  private urlyear: string="/scores/year";
  private url_yearname: string="/scores/name/batch";
  private urlbname: string="/scores/batch/testname";
  private studentdetailsurl: string=" ";
  private studenturl: string=" ";
  private formDetailsUrl:string;
  private detailsUrl: string="/add/score";

 
  constructor(private http: HttpClient) { }
 

  public getyear():Observable<number[]>{
  console.log(this.urlyear);
  return this.http.get<number[]>(this.urlyear);
 }

   public getbatches(name:number):Observable<string []>{
     console.log(name);
    this.url_yearname = "/scores/"+ name+"/batch";
    return this.http.get<string[]>(this.url_yearname);
     }

     public gettests(bname:string):Observable<Tests>{
       console.log(bname);
      this.urlbname = "/scores/"+bname+"/testname";
      return this.http.get<Tests>(this.urlbname);
       }

  public getList(somelist:string):Observable<IReport[]>{
    return this.http.get<IReport []>(somelist);
  }
  
  


    public getDetails(id:string):Observable<Student[]>{
      console.log(id);
      this.studenturl="/scores/"+id;
      console.log(this.studenturl);
      return this.http.get<Student []>(this.studenturl);
       }
       public getStudentDetailsbyName(name:string):Observable<Student[]>{
        console.log(name);
        this.studentdetailsurl="/scores/name/"+name;
        console.log(this.studentdetailsurl);
        return this.http.get<Student []>(this.studentdetailsurl);
         }
  

       public getDetailsinForm(id: number):Observable<Employee>{
        console.log(id);
        this.formDetailsUrl="/employee/"+id;
        console.log(this.studentdetailsurl);
        return this.http.get<Employee>(this.formDetailsUrl);
         }

       public addNewDetails(details: Details): Observable<Details> {
        console.log(details);
        return this.http.post<Details>(this.detailsUrl, details);
        
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
