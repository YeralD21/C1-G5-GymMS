import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routes';
import { UnauthorizedComponent } from './components/unauthorized/unauthorized.component';

@NgModule({
    declarations: [
        UnauthorizedComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule
    ],
    providers: [],
})
export class AppModule { }
