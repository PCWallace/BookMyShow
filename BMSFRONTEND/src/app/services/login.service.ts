import { Injectable } from '@angular/core';
import { LoginComponent } from '../Components/login/login.component';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    body$: Observable<any>;

    constructor(private login: LoginComponent) {}

    verify(userName: string, password: string): boolean {
        return false;
    }
}
