import { Component, Input, OnInit, Output } from '@angular/core';
import { Book } from '../book/BookModel';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { BookService } from '../book/book.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})


export class BookFormComponent implements  OnInit{
  selectedImageFile: File|null = null;
  selectedPdfFile: File|null = null;
  imageSelectionneeUrl= ''
  pdfSelectionneeUrl= ''


  formData = new FormData();
onPDFSelected(event: any) {

  console.log(event.target.files[0]);
  const file: File = event.target.files[0];
  this.selectedPdfFile = file;
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        //this.bookForm.setValue({"fichierImage": event.target.files[0]})
        this.pdfSelectionneeUrl = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  //throw new Error('Method not implemented.');
}

onImageSelected(event: any) {

  console.log(event.target.files[0]);
  const file: File = event.target.files[0];
  this.selectedImageFile = file;
  console.log(this.selectedImageFile);
  
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        //this.bookForm.setValue({"fichierImage": event.target.files[0]})
        this.imageSelectionneeUrl = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  //throw new Error('Method not implemented.');
}


  async onSubmit() {
  
  this.book = this.bookForm.value
  //const formData = new FormData();
  if(!this.updateting){
    this.book.lienImage = "http://localhost:5000/files/Artboar.jpg"
    this.book.lienFichier = "http://localhost:5000/files/habitude.pdf"
    this.book = await this.bookService.createBook(this.book)
  }
  else{
    this.book = await this.bookService.updateBook(this.book, this.book.id)
  }
  
  this.router.navigate(['book/', this.book.id])
  /*this.http.post('http://localhost:5000/files_upload/', this.formData)
    .subscribe(reponse=>{
      console.log('fichier envoyee avec succes')
    },
    error=>{
      console.log("une erreur s'est produite")
      console.log(error)
    }
    )*/
  /*Object.keys(this.bookForm.controls).forEach(key => {
    const control = this.bookForm.get(key);
    this.formData.append(key, control?.value);
  });*/
  //this.formData.append(fichierImage, event.target.files[0])
  /*console.log(this.bookForm.value)
  console.log(this.bookForm.status);
  if (!this.selectedFile) {
    return;
  }

  const formData = new FormData();
  formData.append('file', this.selectedFile);
  formData.append('fruit', JSON.stringify(this.fruit));

  this.http.post('http://localhost:9100/erick', this.fruit)
    .subscribe(
      response => {
        console.log('Fichier envoyé avec succès !', response);
        // Faire quelque chose avec la réponse de l'API
      },
      error => {
        console.error('Une erreur s\'est produite lors de l\'envoi du fichier :', error);
        // Gérer l'erreur de l'API
      }
    );

  console.log('oooooooooooooooooooooooooooooooooooooooo')
}*/
  
}
  @Input() book : Book = new Book();
  bookForm: FormGroup = this.formBuilder.group({
    titre: ['', Validators.required],
    auteur: [''],
    annee : ['', Validators.compose([Validators.max(this.getActualFullYear()), ])],
    editeur: [''],
    description: ['', ],
    fichierPDF: ['',],
    fichierImage: ['']
  })
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private bookService: BookService, private router:Router){}

  updateting: boolean = false
  ngOnInit(): void {
    //this.book.auteur = "522200000"
    if(this.book.id != '')
      this.updateting = true
    this.bookForm.patchValue(this.book)


  }

  getActualFullYear():number{
    return new Date().getFullYear()
  }

  formControlIsInvalid(myFormControl: AbstractControl<any, any>| null): boolean{
    return myFormControl?.invalid && (myFormControl?.dirty || myFormControl?.touched) || false
  }

  get auteur(){
    return this.bookForm.get("auteur")
  }
  get titre(){
    return this.bookForm.get('titre')
  }get annee(){
    return this.bookForm.get("annee")
  }get description(){
    return this.bookForm.get("description")
  }get editeur(){
    return this.bookForm.get("editeur")
  }get fichierPDF(){
    return this.bookForm.get("fichierPDF")
  }get fichierImage(){
    return this.bookForm.get("fichierImage")
  }

  validatePDF(control: AbstractControl<any, any>){
    const file = control.value;
    if(file){
      const fileType = file.type
      console.log(file);
      
      console.log(fileType)
      if(fileType !== 'application/pdf')
        return {'Mauvais format de fichier': true}
      
    }
    return null
  }
  validateImage(control: AbstractControl<any, any>){
    const file = control.value;
    if(file){
      const fileType = file.type
      console.log(file);
      
      console.log(fileType)
      if(fileType !== 'application/png')
        return {'Mauvais format de fichier': true}
      
    }
    return null
  }
 }
