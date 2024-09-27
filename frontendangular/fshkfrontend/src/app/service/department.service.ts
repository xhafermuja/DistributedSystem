import { Injectable } from '@angular/core';
import { Department} from '../model/department';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';



@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllDepartments():Observable<Department[]>{
    return this.http.get<Department[]>(this.apiServerUrl+'/api/department/v2/getAll');
  }


  public addDepartment(department: Department):Observable<Department>{
    return this.http.post<Department>(this.apiServerUrl+'/api/department/save', department);
  }

  public updateDepartment(department: any):Observable<any>{
    const departmentId= department?.departmentId;
    return this.http.put<Department>(this.apiServerUrl+'/api/department/'+departmentId, department);
  }

  public deleteDepartment(department:any): Observable<void>{
    const departmentId= department?.departmentId;
    return this.http.delete<void>(this.apiServerUrl+'/api/department/'+departmentId);
  }
}
