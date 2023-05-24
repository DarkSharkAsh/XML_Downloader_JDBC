import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable
({
  providedIn: 'root'
})
export class XMLServicesService {

  constructor(private httpClient: HttpClient) { }


  
  public downloadFile(id:number) {
    const url = `http://localhost:8080/new/${id}`;
    window.location.href = url;
  }

}
