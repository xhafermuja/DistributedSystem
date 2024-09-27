import { Component, Inject, OnInit } from '@angular/core';
import { LoginService } from '../../../service/login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms'; 
import { HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-register-page',
  standalone: true,
  imports: [HttpClientModule, ReactiveFormsModule],
  templateUrl: './register-page.component.html',
  styleUrl: './register-page.component.css'
})
export class RegisterPageComponent implements OnInit {
  
  public registerForm:FormGroup  | any;

  constructor(private service: LoginService, private fb:FormBuilder){
    
  }

  ngOnInit(): void {
    this.registerForm= this.fb.group({
      name:['', [Validators.required]],
      email:['', [Validators.required, Validators.email]],
      password:['', [Validators.required]],
      confirmPassword:['', [Validators.required]],
    }, { validator: this.passwordMathValidator})
  }

  passwordMathValidator(formGroup: FormGroup){
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;

    if(password != confirmPassword){
      formGroup.get('confirmPassword')?.setErrors({passwordMismatch : true});
    }else{
      formGroup.get('confirmPassword')?.setErrors(null)
    }
  }

  submitForm(){
    console.log(this.registerForm?.value);

    this.service.register(this.registerForm.value).subscribe(
      (response)=>{
        if(response.id != null){
          alert("Hello "+ response.name)
        }
      }
    )

  }

}
