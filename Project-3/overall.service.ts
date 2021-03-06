import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import { map, filter, switchMap } from 'rxjs/operators';
import { Overallqc } from '../../overallqc';
import { HttpClient } from '@angular/common/http';
import { Note } from '../types/Note';

@Injectable({
  providedIn: 'root'
})
export class OverallService {
  private baseUrl:string= 'http://localhost:7861';
  private baseUrl1: string = 'http://localhost:9075';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});
  constructor(private _http:Http, private http: HttpClient) { }
  private overallqc = new Overallqc(); 
  getOverallQC(id:Number){

    return this._http.get(this.baseUrl+'/note/'+id,this.options).pipe(map((response:Response)=>response.json()));
      // .catch(this.errorHandler);
   }
  updateOverallQC(overallqc:Overallqc){

    return this._http.put(this.baseUrl+'/note/update',JSON.stringify(overallqc),this.options).pipe(map((response:Response)=>response.json()));
      // .catch(this.errorHandler);
   }

   updateOverallStatus(qcStatus: String) {
     //return this.http.put<Overallqc>()
   }


   getOverallSmileyStatus(): Observable<Note> {
    return this.http.get<Note>(this.baseUrl1 +'/audit/notes/overall/1/4');
  }

   createOverallQC(overallqc:Overallqc){

    return this._http.post(this.baseUrl+'/note/create',JSON.stringify(overallqc),this.options).pipe(map((response:Response)=>response.json()));
     //  .catch(this.errorHandler);
   }


  setter(overallqc:Overallqc){
    this.overallqc =overallqc;
 }
 
 getter(){
    return this.overallqc;
 }

 errorHandler(error:Response){
  return Observable.throw(error || "SERVER ERROR");
}
}
