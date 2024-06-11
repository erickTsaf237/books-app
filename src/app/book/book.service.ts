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

download(url: string): Observable<Blob> {
  return this.http.get(url, {
    responseType: 'blob'
  })
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
  

  getOneBooks(id:string): Promise<Book> {
    return new Promise<Book>((resolve, reject) => {
      this.http.get<Book>(this.http_path+id, { observe: 'response' }).subscribe(
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
  deleteBook(id:string): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      this.http.delete<any>(this.http_path+id, { observe: 'response' }).subscribe(
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

  createBook(book: Book): Promise<any> {
    //this.http.post()
    return new Promise<any>((resolve, reject) => {
      this.http.post<any>(this.http_path, book, { observe: 'response' }).subscribe(
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

  updateBook(book: Book, id: string): Promise<any> {
    //this.http.post()
    return new Promise<any>((resolve, reject) => {
      this.http.post<any>(this.http_path+id, book, { observe: 'response' }).subscribe(
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

  
