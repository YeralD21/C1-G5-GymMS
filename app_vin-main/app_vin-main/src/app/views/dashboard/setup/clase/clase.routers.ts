import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClaseNewComponent } from './components/form/clase-new.component';
import { ClaseEditComponent } from './components/form/clase-edit.component';
import { ClaseContainerComponent } from './containers/clase-container.component';

const routes: Routes = [
    { path: 'clases', component: ClaseContainerComponent },
    { path: 'clases/new', component: ClaseNewComponent },
    { path: 'clases/edit/:id', component: ClaseEditComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ClaseRoutingModule { }
