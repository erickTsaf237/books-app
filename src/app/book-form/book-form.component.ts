import { Component, Input, OnInit } from '@angular/core';
import { Book } from '../book/BookModel';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent implements  OnInit{
  imageSelectionneeUrl= ''
onPDFSelected(event: any) {

  console.log(event.target.files[0]);
  const file: File = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = (e: any) => {
        this.imageSelectionneeUrl = e.target.result;
      };
      reader.readAsDataURL(file);
    }
  //throw new Error('Method not implemented.');
}
onSubmit() {
  console.log(this.bookForm.value)
  console.log(this.bookForm.status);
  
}
  @Input() book : Book = new Book();
  bookForm: FormGroup = this.formBuilder.group({
    titre: ['', Validators.required],
    auteur: [''],
    annee : ['', Validators.compose([Validators.max(this.getActualFullYear())])],
    editeur: [''],
    description: ['', ],
    fichierPDF: ['', Validators.compose([Validators.required])],
    fichierImage: ['']
  })
  constructor(private formBuilder: FormBuilder){}
  ngOnInit(): void {
    //this.book.auteur = "522200000"
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
