import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Lenda } from '../../../model/lenda';
import { LendaService } from '../../../service/lenda.service';
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-lendet-page',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './lendet-page.component.html',
  styleUrl: './lendet-page.component.css',
  providers:[LendaService]
})
export class LendetPageComponent implements OnInit{
  public lendetSD: Lenda[]=[];
  public lendetTIT: Lenda[]=[];

  constructor(private lendaService:LendaService){

  }

  ngOnInit(): void {
    this.getLendetSD();
    this.getLendetTIT();
  }

  public getLendetSD(){

    this.lendaService.getAllLendaSD().subscribe(
      (response: Lenda[]) =>{
        this.lendetSD= response;  
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )

  }
  
  public getLendetTIT(){

    this.lendaService.getAllLendaTIT().subscribe(
      (response: Lenda[]) =>{
        this.lendetTIT= response;  
        console.log(this.lendetTIT);
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    )

  }

}
