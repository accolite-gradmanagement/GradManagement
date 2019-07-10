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
import { addTestinfo } from './addTestinfo';


@Injectable({
  providedIn:'root'
})

export class ReportService {
  private _url ="http://localhost:8080";
/*   private url: string= "/assets/test.json";
 */  private urlyear: string=this._url+"/scores/year";
  private url_yearname: string=this._url;
  private urlbname: string=this._url;
  private studentdetailsurl: string=this._url;
  private studenturl: string=this._url;
  private formDetailsUrl:string=this._url;
  private detailsUrl: string=this._url+"/add/score";

 
  constructor(private http: HttpClient) { }
 

  public getyear():Observable<number[]>{
  console.log(this.urlyear);
  return this.http.get<number[]>(this.urlyear);
 }

   public getbatches(name:number):Observable<string []>{
     console.log(name);
    return this.http.get<string[]>(this._url+ "/scores/"+ name+"/batch");
     }

     public gettests(bname:string):Observable<Tests[]>{
       console.log(bname);
      
      return this.http.get<Tests[]>(this._url+"/scores/"+bname+"/testname");
       }

  public getList(somelist:string):Observable<IReport[]>{
    return this.http.get<IReport []>(this._url+somelist);
  }
  
  public getDetails(id:string):Observable<Student[]>{
    console.log(id);
    
    
    return this.http.get<Student []>(this._url+"/scores/"+id);
     }
     public getStudentDetailsbyName(name:string):Observable<Student[]>{
      console.log(name);
      return this.http.get<Student []>(this._url+"/scores/name/"+name);
       }

       public getDetailsinForm(id: number):Observable<Employee>{
        console.log(id);
        
        console.log(this.studentdetailsurl);
        return this.http.get<Employee>(this._url+"/employee/"+id);
         }
         public gettestDetailsinForm(tId: number):Observable<addTestinfo>{
          console.log(tId);
          this.formDetailsUrl="/gradTests/"+tId;
         
          return this.http.get<addTestinfo>(this.formDetailsUrl);
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
