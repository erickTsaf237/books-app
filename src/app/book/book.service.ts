import { Injectable } from '@angular/core';
import { Book } from './BookModel';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  constructor(private http: HttpClient) { }
  http_path: string = "http://localhost:5000/book/"

getAllBooks(): Observable<Book[]> {
  return this.http.get<Book[]>(this.http_path)
}

  getAllBooks2(): Promise<Book[]> {
    return new Promise<Book[]>((resolve, reject) => {
      this.http.get<Book[]>(this.http_path, { observe: 'response' }).subscribe(
        response => {
          //console.log(response.body);
          resolve(response.body!);
        },
        error => {
          console.error(error);
          reject(error);
        }
      );
    });
  }
  }

  
