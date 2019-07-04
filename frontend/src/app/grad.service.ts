
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Grad } from './gradManagement/gradmanagement/Grad'; 


@Injectable({
  providedIn: 'root'
})
export class GradService {

  private baseUrl = 'http://localhost:8082/grads';

  constructor(private http: HttpClient) { }

  getGrad(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createGrad(grad: Grad): Observable<Grad> {
    return this.http.post<Grad>(`${this.baseUrl}`, grad);
  }

  updateGrad(id: number, value: Grad): Observable<Grad> {
    return this.http.put<Grad>(`${this.baseUrl}/${id}`, value);
  }

  deleteGrad(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getGradsList(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }
}