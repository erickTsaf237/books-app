import { Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookFormComponent } from './book-form/book-form.component';



export const routes: Routes = [
    {
        path: '',
        title: "Accueille",
        component: BookListComponent,
    },
    {
        path: 'book/:id',
        title: "Detaille",
        component: BookDetailComponent,
    },
    {
        path: 'new',
        title: "nouveau livre",
        component: BookFormComponent,
    }
];
