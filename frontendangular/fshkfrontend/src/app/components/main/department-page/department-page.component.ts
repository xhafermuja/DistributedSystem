import { Component, OnInit } from '@angular/core';
import { Department } from '../../../model/department';
import { DepartmentService } from '../../../service/department.service';
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-department-page',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './department-page.component.html',
  styleUrl: './department-page.component.css',
  providers:[DepartmentService]
})
export class DepartmentPageComponent implements OnInit{
  public departments: Department[] = []; 

  constructor(private departmentService: DepartmentService){
  }

  ngOnInit(){
    this.getDepartments();
    
  }
    public getDepartments():void{

      
      this.departmentService.getAllDepartments().subscribe(
        (response: Department[]) =>{
          this.departments= response;  
        },
        (error: HttpErrorResponse) =>{
          alert(error.message);
        }
      )

  }

}
