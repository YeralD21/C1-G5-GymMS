import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { abcForms } from '../../../../../../../environments/generals';
import { Clase } from '../../models/clase'; // Asegúrate de que esta importación es correcta
import { Instructor } from '../../models/instructor'; // Asegúrate de que esta importación es correcta
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDialogRef } from '@angular/material/dialog';
import { InstructorService } from '../../../../../providers/services/setup/instructor.service';

@Component({
    selector: 'app-clase-edit',
    standalone: true,
    imports: [
        FormsModule,
        MatIconModule,
        MatButtonModule,
        ReactiveFormsModule,
        MatSlideToggleModule,
        MatFormFieldModule,
        MatInputModule,
    ],
    template: `
        <div class="flex flex-col max-w-240 md:min-w-160 max-h-screen -m-6">
            <!-- Header -->
            <div class="flex flex-0 items-center justify-between h-16 pr-3 sm:pr-5 pl-6 sm:pl-8 bg-primary text-on-primary">
                <div class="text-lg font-medium">{{ title }}</div>
                <button mat-icon-button (click)="cancelForm()" [tabIndex]="-1">
                    <mat-icon class="text-current" [svgIcon]="'heroicons_outline:x-mark'"></mat-icon>
                </button>
            </div>

            <!-- Compose form -->
            <form class="flex flex-col flex-auto p-6 sm:p-8 overflow-y-auto" [formGroup]="claseForm">
                <mat-form-field>
                    <mat-label>Tipo</mat-label>
                    <input matInput formControlName="tipo" />
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Hora</mat-label>
                    <input matInput formControlName="hora" />
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Costo</mat-label>
                    <input matInput formControlName="costo" type="number" />
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Cupos Disponibles</mat-label>
                    <input matInput formControlName="cuposDisponibles" type="number" />
                </mat-form-field>
                <mat-form-field>
                    <mat-label>Instructor</mat-label>
                    <select matNativeControl formControlName="instructor">
                        <option *ngFor="let instructor of instructors" [value]="instructor.id">{{ instructor.nombre }}</option>
                    </select>
                </mat-form-field>
                <!-- Actions -->
                <div class="flex flex-col sm:flex-row sm:items-center justify-between mt-4 sm:mt-6">
                    <div class="flex space-x-2 items-center mt-4 sm:mt-0 ml-auto">
                        <button mat-stroked-button color="warn" (click)="cancelForm()">Cancelar</button>
                        <button mat-stroked-button color="primary" (click)="saveForm()">Guardar</button>
                    </div>
                </div>
            </form>
        </div>
    `,
})
export class ClaseEditComponent implements OnInit {
    @Input() title: string = '';
    @Input() clase: Clase; // Aquí aseguramos que 'Clase' es usado como un tipo
    abcForms: any;
    instructors: Instructor[] = [];

    claseForm = new FormGroup({
        tipo: new FormControl('', [Validators.required]),
        hora: new FormControl('', [Validators.required]),
        costo: new FormControl(0, [Validators.required]),
        cuposDisponibles: new FormControl(0, [Validators.required]),
        instructor: new FormControl('', [Validators.required])
    });

    constructor(
        private formBuilder: FormBuilder,
        private dialogRef: MatDialogRef<ClaseEditComponent>,
        private instructorService: InstructorService
    ) {}

    ngOnInit() {
        this.abcForms = abcForms;
        this.instructorService.getAll$().subscribe(
            (response) => {
                this.instructors = response;
            },
            (error) => {
                console.error('Error fetching instructors:', error);
            }
        );

        if (this.clase) {
            this.claseForm.patchValue({
                tipo: this.clase.tipo,
                hora: this.clase.hora,
                costo: this.clase.costo,
                cuposDisponibles: this.clase.cuposDisponibles,
                instructor: this.clase.instructor?.id || ''
            });
        }
    }

    public saveForm(): void {
        if (this.claseForm.valid) {
            this.dialogRef.close(this.claseForm.value);
        }
    }

    public cancelForm(): void {
        this.dialogRef.close(null);
    }
}
