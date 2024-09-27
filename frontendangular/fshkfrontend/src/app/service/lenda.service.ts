import { Injectable } from '@angular/core';
import { Lenda } from '../model/lenda';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class LendaService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  
  public getAllLendaSD():Observable<Lenda[]>{
    return this.http.get<Lenda[]>(this.apiServerUrl+'/api/lenda/getAllLendaSD');
  }

  public getAllLendaTIT():Observable<Lenda[]>{
    return this.http.get<Lenda[]>(this.apiServerUrl+'/api/lenda/getAllLendaTIT');
  }


//   public addDepartment(department: Department):Observable<Department>{
//     return this.http.post<Department>(this.apiServerUrl+'/department/save', department);
//   }

//   public updateDepartment(department: any):Observable<any>{
//     const departmentId= department?.departmentId;
//     return this.http.put<Department>(this.apiServerUrl+'/department/'+departmentId, department);
//   }

//   public deleteDepartment(department:any): Observable<void>{
//     const departmentId= department?.departmentId;
//     return this.http.delete<void>(this.apiServerUrl+'/department/'+departmentId);
//   }
}
