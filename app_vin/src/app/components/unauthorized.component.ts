import { Component } from '@angular/core';

@Component({
    selector: 'app-unauthorized',
    template: '<h1>No estás autorizado para ver esta página</h1>',
    styles: ['h1 { color: red; }']
})
export class UnauthorizedComponent { }
