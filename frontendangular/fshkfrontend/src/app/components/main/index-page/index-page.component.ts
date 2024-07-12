import { Component } from '@angular/core';
import { RouterOutlet, RouterLink, RouterLinkActive, Router } from '@angular/router';

@Component({
  selector: 'app-index-page',
  standalone: true,
  imports: [ RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './index-page.component.html',
  styleUrl: './index-page.component.css'
})
export class IndexPageComponent {
  constructor(private router:Router){}

  goDepartment(){
    this.router.navigate(['/department-page']);
  }
  goAdmin(){
    this.router.navigate(['/login-page']);
  }
}
