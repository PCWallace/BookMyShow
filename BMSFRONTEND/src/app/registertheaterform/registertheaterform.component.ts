import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { RegistertheaterformService } from '../services/registertheaterform.service';

@Component({
    selector: 'app-registertheaterform',
    templateUrl: './registertheaterform.component.html',
    styleUrls: ['./registertheaterform.component.css']
})
export class RegistertheaterformComponent implements OnInit {
    registerTheaterForm: FormGroup;
    @Input() city: string;

    constructor(
        private router: Router,
        private fb: FormBuilder,
        private service: RegistertheaterformService
    ) {
        this.registerTheaterForm = this.fb.group({
            theaterName: ['', Validators.required],
            theaterAddress: ['', Validators.required]
        });
    }

    // registerTheaterForm = new FormGroup({
    //     name: new FormControl('', [Validators.required]),
    //     address: new FormControl('', [Validators.required])
    // });
    ngOnInit() {}

    submit() {
        console.log(this.registerTheaterForm.value);
        const formValues = this.registerTheaterForm.value;
        this.service.submit(formValues, this.city).subscribe(data => {
            console.log(data.body);
        });
    }
}
