import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/take';
import { CategoryService } from '../../services/category/category.service';
import { ProductService } from '../../services/product/product.service';
import { Observable } from 'rxjs';
import { FileLinkService } from '../../services/file-link/file-link.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  categories$;
  fileLinks$;
  course = {};
  id;
  linkToFile;

  uploadPercent: Observable<number>;
  downloadURL: Observable<string>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private categoryService: CategoryService,
    private productService: ProductService,
    private fileLinkService: FileLinkService) {
    this.categories$ = categoryService.getAll();
    this.fileLinks$ = fileLinkService.getAll();

    //read address from the router, get id(key
    this.id = this.route.snapshot.paramMap.get('id');
    /**
     * OBS
     * This is the part that gets an observable from the db, it is stored in
     * the course field
     */
    if (this.id) {
      this.productService.get(this.id)
        .valueChanges()
        .take(1)
        .subscribe(c => this.course = c);
    }
  }

  /*
  If we got an ID from constructor, then is not create new course
  and it redirects to function update. 
  */

  save(product) {
    if (this.id) {
      this.productService.updateProduct(this.id, product);
    } else {
      this.productService.create(product);
    }
    this.router.navigate(['/admin/courses']);
  }

  delete() {
    if (!confirm('Do you want to delete this course?')) return;
    this.productService.deleteProduct(this.id);
    this.router.navigate(['/admin/courses']);
  }

  back() {
    if (!confirm('Go back to courses without saving?')) return;
    this.router.navigate(['/admin/courses']);
  }

  startUpload(event: any) {
    const file: File = event.target.files[0];
    const filePath = `${this.id}`;
    const ref = this.productService.uploadFile().ref(filePath);
    const task = this.productService.uploadFile().upload(filePath, file);

    // observe percentage changes
    this.uploadPercent = task.percentageChanges();
    this.downloadURL = ref.getDownloadURL();
  }

  //creates the fields in the db wit the links to download
  pushLink() {
    this.downloadURL.subscribe(v => this.linkToFile = v);

    this.fileLinkService.create(this.linkToFile || null, this.id);
  }

  update(){
    this.productService.updateProduct(this.id, this.course);
  }

  ngOnInit() {

  }

}
