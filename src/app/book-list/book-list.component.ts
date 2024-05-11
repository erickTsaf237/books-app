import { Component, OnInit } from '@angular/core';
import { BookComponent } from '../book/book.component';
import { Book } from '../book/BookModel';
import { BookService } from '../book/book.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [BookComponent, CommonModule],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{
  constructor(private bookService: BookService){

  }

  ngOnInit(): void {
    this.bookList$ = this.bookService.getAllBooks()
  }

  bookList$: Observable<Book[]>|undefined

  
}
