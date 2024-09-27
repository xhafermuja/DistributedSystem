import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../../service/login.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent implements OnInit {
  public loginForm: FormGroup | any;


  constructor(private router:Router, private service:LoginService, private fb:FormBuilder){}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    })
  }

  goRegister(){
    this.router.navigate(['/register-page']);
  }

  
  submitForm() {
    this.service.login(this.loginForm.value).subscribe(
      (response) => {
        console.log(response);
        if (response.jwt != null) {
          alert("Hello, Your token is " + response.jwt);
          const jwtToken = response.jwt;
          localStorage.setItem('jwt', jwtToken);
          this.router.navigateByUrl("/admin-page");
        }
      }
    )
  }
}
