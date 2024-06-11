import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../book/BookModel';
import { BookListComponent } from '../book-list/book-list.component';
import { ActivatedRoute } from '@angular/router';
import { BookService } from '../book/book.service';
import { Observable } from 'rxjs';
import { RouterLink, RouterOutlet , Router} from '@angular/router';


@Component({
  selector: 'app-book-detail',
  standalone: true,
  imports: [BookListComponent, RouterLink, RouterOutlet],
  templateUrl: './book-detail.component.html',
  styleUrl: './book-detail.component.css'
})
export class BookDetailComponent implements OnInit {
  book?: Book;

  constructor(private route:ActivatedRoute, private bookService: BookService , private router: Router){}
  
  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      this.bookService.getOneBooks(id!).then(value=>{this.book = value})
    }

    //throw new Error('Method not implemented.');
  }


  async deleteBook(){
    await this.bookService.deleteBook(this.book!.id)
    this.router.navigate([''])
  }

  async updateBook(){
    await this.bookService.deleteBook(this.book!.id) 
    this.router.navigate([''])
  }

}
