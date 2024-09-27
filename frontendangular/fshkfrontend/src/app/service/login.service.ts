import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public login(loginRequest:any): Observable<any>{
    return this.http.post(this.apiServerUrl+'/login', loginRequest)
  }

  public register(signRequest:any): Observable<any>{
    return this.http.post(this.apiServerUrl+'/signup', signRequest)
  }

}
