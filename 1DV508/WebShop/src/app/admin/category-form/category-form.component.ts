import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../services/category/category.service';
import { Router, ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/take';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
/**
 * This components is similar to product-form component. 
 */
export class CategoryFormComponent implements OnInit {
  categories$;
  category = {};
  id;

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router) {
    this.categories$ = this.categoryService.getAll();
    this.id = this.route.snapshot.paramMap.get('id');

    if (this.id) {
      console.log(">>>>ID: " + this.id);
      this.categoryService.get(this.id)
        .valueChanges()
        .take(1)
        .subscribe(c => this.category = c);
    }
  }

  save(categories) {
    if (this.id) {
      this.categoryService.update(this.id, categories);
    } else {
      this.categoryService.create(categories);
    }
    this.router.navigate(['/admin/categories']);
  }

  delete() {
    if (!confirm('Do you want to delete this course?')) return;
    this.categoryService.delete(this.id);
    this.router.navigate(['/admin/categories']);
  }

  back() {
    if (!confirm('Go back to categories without saving?')) return;
    this.router.navigate(['/admin/categories']);
  }

  ngOnInit() {

  }

}
