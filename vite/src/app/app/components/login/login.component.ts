import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Login } from './login';


import { AuthenticationService } from '../../../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {
    model = new Login('', '');
    submitted : boolean = false;
    response : Object;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private auth: AuthenticationService
    ) {
        // redirect to home if already logged in
        if (this.auth.authToken) { 
            this.router.navigate(['/']);
        }
    }

    ngOnInit() { 
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
         }

    onSubmit() {
      this.submitted = true;
      this.response = this.auth.login(this.model)
      .subscribe(
          response => { 
              localStorage.setItem('authToken', response.headers.get("Authorization"));
              this.router.navigate([this.returnUrl]);
          },
             error => { console.log("error in login"); }
              );
    }
}
