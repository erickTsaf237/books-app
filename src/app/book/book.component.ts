import { Component, Input, OnInit } from '@angular/core';
import { Book } from './BookModel';

@Component({
  selector: 'app-book',
  standalone: true,
  imports: [],
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent implements OnInit {
  ngOnInit(): void {
    console.log(this.book)
  }

public downloadResource() {
  //alert("")
  const resourceUrl = this.book.lienImage;
  const link = document.createElement('a');
  link.href = resourceUrl;
  link.download = 'erick.pdf'; // Remplacez par le nom souhaité pour le fichier téléchargé
  link.click();
}
  @Input()
  book!: Book;
}
