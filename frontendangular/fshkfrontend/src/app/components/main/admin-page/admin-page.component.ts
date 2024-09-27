
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm} from '@angular/forms';
import { DepartmentService } from '../../../service/department.service';
import { Department } from '../../../model/department';

@Component({
  selector: 'app-admin-page',
  standalone: true,
  imports: [HttpClientModule, FormsModule],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.css'
})
export class AdminPageComponent implements OnInit{
  public departments: Department[] = []; 
  public editDepartment?: Department;
  public departmentId?:Department;

  constructor(private departmentService:DepartmentService){}

  ngOnInit() {
      this.getDepartments();
  }

  public getDepartments(){
    this.departmentService.getAllDepartments().subscribe(
      (response: Department[]) =>{
        this.departments= response;  
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )
  }

  public onAddDepartment(addForm:NgForm):void{
    this.departmentService.addDepartment(addForm.value).subscribe(
      (response:Department) =>{
        console.log(response);
        this.getDepartments();
      },
      (error:HttpErrorResponse) =>{
        alert(error.message)
      }
    )
  }

  public onUpdateDepartment(department:any):void{
    this.editDepartment=department;

    this.departmentService.updateDepartment(this.editDepartment).subscribe(
      (response:Department) =>{
        console.log(response);
        this.getDepartments();
      },
      (error:HttpErrorResponse) =>{
        alert(error.message)
      }
    )
  }

  public onDeleteDepartment(department:any):void{
    this.departmentId=department;
  this.departmentService.deleteDepartment(this.departmentId).subscribe(
    (response:void) =>{
      console.log(response);
      this.getDepartments();
    },
    (error:HttpErrorResponse) =>{
      alert(error.message)
    }
  )
  }

}
