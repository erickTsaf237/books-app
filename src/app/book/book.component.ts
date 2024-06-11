import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Book } from './BookModel';
import { BookService } from './book.service';
import { Observable } from 'rxjs';
import { RouterLink, RouterOutlet, Router } from '@angular/router';


@Component({
  selector: 'app-book',
  standalone: true,
  imports: [RouterLink, RouterOutlet],
  templateUrl: './book.component.html',
  styleUrl: './book.component.css'
})
export class BookComponent implements OnInit {
  ngOnInit(): void {
    console.log(this.book)
  }
  @Output() incrementCountEvent = new EventEmitter<string>();

  constructor(private bookService: BookService, private router: Router){
  }

  public onclick(){
    this.router.navigate(['book/', this.book.id])
    this.ngOnInit()
    //this.incrementCountEvent.emit(this.book.id);
  }

public downloadResource() {
  //alert("")
  const resourceUrl = this.book.lienImage;
  const link = document.createElement('a');
  link.href = resourceUrl;
  link.download = 'erick.pdf'; // Remplacez par le nom souhaité pour le fichier téléchargé
  link.click();
}



downloadFile(fileUrl: string) {
  const link = document.createElement('a');
  link.setAttribute('href', fileUrl);
  link.setAttribute('download', 'nomDuFichier.ext');
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
}

onClickLink(){
  this.router.navigate(['/book/', this.book.id])
}

download(url: string): Observable<Blob> {
  console.log('llllllllllllllllllllllllllllllllllllllllllllll')
  return this.bookService.download(url);
}
delete(url: string): Observable<Blob> {
  console.log('llllllllllllllllllllllllllllllllllllllllllllll')
  return this.bookService.download(url);
} 

@Input()
  book!: Book;
}
