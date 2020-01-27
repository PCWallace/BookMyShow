import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    errMsg = '';
    error = false;

    constructor(
        private router: Router,
        private fb: FormBuilder,
        private http: HttpClient
    ) {
        this.loginForm = this.fb.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
    }

    ngOnInit() {}

    getValues() {
        const formValues = this.loginForm.value;

        // if (formValues.username.match(/\@epam\.com$/)) {
        const headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        this.error = false;
        const res = this.http
            .post(
                'api/auth',
                {
                    username: formValues.username,
                    password: formValues.password
                },
                { observe: 'response' }
            )
            .subscribe(
                (data: any) => {
                    console.log(data.status);
                    if (data.status === 200) {
                        localStorage.setItem(
                            'tokken',
                            data.headers.get('Authorization')
                        );
                        this.router.navigate(['/home']);
                    }
                    console.log(data.status);
                },
                err => console.log(err)
            );
    }
}
