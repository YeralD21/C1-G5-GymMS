import { Component, OnInit } from '@angular/core';
import { ClaseService } from '../../services/clase.service';
import { InstructorService } from '../../services/instructor.service';
import { Clase } from '../../models/clase';
import { Instructor } from '../../models/instructor';

@Component({
    selector: 'app-clase',
    templateUrl: './clase.component.html',
    styleUrls: ['./clase.component.css']
})
export class ClaseComponent implements OnInit {
    clases: Clase[] = [];
    instructors: Instructor[] = [];
    selectedClase: Clase | null = null;

    constructor(
        private claseService: ClaseService,
        private instructorService: InstructorService
    ) {}

    ngOnInit(): void {
        this.getClases();
        this.getInstructors();
    }

    getClases(): void {
        this.claseService.getAll$().subscribe((data: Clase[]) => {
            this.clases = data;
        });
    }

    getInstructors(): void {
        this.instructorService.getAll$().subscribe((data: Instructor[]) => {
            this.instructors = data;
        });
    }

    selectClase(clase: Clase): void {
        this.selectedClase = clase;
    }

    createClase(clase: Clase): void {
        this.claseService.createClase(clase).subscribe(() => {
            this.getClases();
            this.selectedClase = null;
        });
    }

    updateClase(clase: Clase): void {
        this.claseService.update(clase.id, clase).subscribe(() => {
            this.getClases();
            this.selectedClase = null;
        });
    }

    deleteClase(clase: Clase): void {
        this.claseService.delete(clase.id).subscribe(() => {
            this.getClases();
        });
    }
}
