import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable, of } from 'rxjs';

import { environment } from '../../environments/environment';

import { Index } from '../home/index';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const BASE_API = environment.BASE_API;

@Injectable({
  providedIn: 'root'
})



export class SearchService {
  public data: any;
  _url = '/data/';
  index_url = "/indices";
        
  constructor(private http: HttpClient) { }

    getGridData(index: string): any {     
    	console.log("index :"+index);    	     
      return this.http.post(BASE_API+this._url+index, '', httpOptions);
    }

    getIndices(): any {     
      return this.http.post(BASE_API+this.index_url, '', httpOptions);
    }

 
}
