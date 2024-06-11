import { Component, OnInit } from '@angular/core';
import { BookComponent } from '../book/book.component';
import { Book } from '../book/BookModel';
import { BookService } from '../book/book.service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';
import { BookFormComponent } from '../book-form/book-form.component';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [BookComponent, CommonModule, BookFormComponent],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{
  selectedBook: Book | undefined;
  constructor(private bookService: BookService){
    this.empty = true;
  }

  ngOnInit(): void {
    this.bookList$ = this.bookService.getAllBooks()
  }

  showBookDetail(book: Book) {
    this.selectedBook = book;
  }

  bookList$: Observable<Book[]>|undefined
  empty : Boolean

  
}
