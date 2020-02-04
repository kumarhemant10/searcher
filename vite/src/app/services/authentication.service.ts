import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from '../../environments/environment';


const BASE_API = environment.BASE_API;

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
	authToken: string;

  	constructor(private http: HttpClient) { 
  		this.authToken = JSON.parse(localStorage.getItem('authToken'));
  	}


    login(user) {
        return this.http.post<any>(BASE_API+`/auth`, JSON.stringify(user), {observe: 'response'});
      }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('authToken');        
    }
}
