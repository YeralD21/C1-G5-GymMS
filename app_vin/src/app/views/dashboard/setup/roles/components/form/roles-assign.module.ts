import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RolesAssignComponent } from './roles-assign.component';

const routes: Routes = [
    { path: '', component: RolesAssignComponent }
];

@NgModule({
    imports: [
        RouterModule.forChild(routes),
        RolesAssignComponent
    ]
})
export class RolesAssignModule {}
