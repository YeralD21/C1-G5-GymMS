import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { AuthUtils } from 'app/core/auth/auth.utils';
import { UserService } from 'app/core/user/user.service';
import { catchError, Observable, of, switchMap, throwError } from 'rxjs';
import { user } from '../../mock-api/common/user/data';

@Injectable({ providedIn: 'root' })
export class AuthService {
    private _authenticated: boolean = false;
    private _httpClient = inject(HttpClient);
    private _userService = inject(UserService);
    private currentUserRole: string;  // Nueva propiedad para almacenar el rol del usuario

    // Métodos existentes...

    constructor() {
        // Inicializa el rol del usuario (esto debería venir de tu lógica de autenticación)
        this.currentUserRole = 'user'; // Ejemplo: este valor debería establecerse según la autenticación real
    }

    getCurrentUserRole(): string {
        // Este método debería devolver el rol actual del usuario
        return this.currentUserRole;
    }

    setCurrentUserRole(role: string): void {
        // Este método permite establecer el rol del usuario
        this.currentUserRole = role;
    }

    // Otros métodos existentes...
}
