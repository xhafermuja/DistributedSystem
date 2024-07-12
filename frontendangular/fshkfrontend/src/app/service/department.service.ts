import { Injectable } from '@angular/core';
import { Department} from '../model/department';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
;
import { environment } from '../../environments/environment.development';



@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllDepartments():Observable<Department[]>{
    return this.http.get<Department[]>(this.apiServerUrl+'/department/api/v2/getAll');
  }


  public addDepartment(department: Department):Observable<Department>{
    return this.http.post<Department>(this.apiServerUrl+'/department/save', department);
  }

  public updateDepartment(department: Department):Observable<Department>{
    return this.http.put<Department>('${this.apiServerUrl}/department/update', department);
  }

  public deleteDepartment(departmentId:number, department: Department): Observable<void>{
    return this.http.delete<void>('${this.apiServerUrl}/department/${departmentId}');
  }
}
