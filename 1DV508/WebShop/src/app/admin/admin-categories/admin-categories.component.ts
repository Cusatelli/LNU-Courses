import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from '../../services/category/category.service';

@Component({
  selector: 'app-admin-categories',
  templateUrl: './admin-categories.component.html',
  styleUrls: ['./admin-categories.component.css']
})
export class AdminCategoriesComponent implements OnInit {
  categories$;

  constructor(
    private categoryService: CategoryService,
    private router: Router) {
    this.categories$ = categoryService.getAll();
  }

  OnEdit(id: string) {
    this.router.navigate(['/admin/categories/', id])
  }

  ngOnInit() {

  }

}
