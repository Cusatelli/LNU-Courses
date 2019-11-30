import { Component, OnInit, OnDestroy, wtfCreateScope } from '@angular/core';
import { ProductService } from '../services/product/product.service';
import { CategoryService } from '../services/category/category.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/product';
import 'rxjs/add/operator/switchMap';
import { ShoppingCartService } from '../services/shopping-cart/shopping-cart.service';
import { Subscription } from 'rxjs';
import { convertToR3QueryMetadata } from '@angular/core/src/render3/jit/directive';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit, OnDestroy {
  subscribtion: Subscription;
  cart: any;
  categories$;
  category: string;
  filterProducts: Product[] = [];
  products: Product[] = [];
  userSearch = "";
  selectedOrdering = 0;

  constructor(
    route: ActivatedRoute,
    productService: ProductService,
    categoryService: CategoryService,
    private cartService: ShoppingCartService) {
    this.categories$ = categoryService.getAll();

    productService
      .getAll()
      .switchMap(products => {
        this.products = products;
        return route.queryParamMap;
      })
      .subscribe(params => {
        this.category = params.get('category');
        this.setCourseFilter();
      });

  }
 

  //KeyUp
  searchQuery(query: string) {
    this.userSearch = query;
    this.setCourseFilter();
  }

  courseFilter(){    
    return this.products.filter(p =>
      p.title.toLowerCase().includes(
        this.userSearch.toLowerCase()) && this.categoryCheck(p.category));
  }

  categoryCheck(courseCategory: string) {
    return courseCategory === this.category || !this.category;
  }

  setCourseFilter(){
    this.filterProducts = this.courseFilter();
  }

  

/**
 * There is a bug in switch. If you put the value alone, it will 
 * fall to default.
 * Add a "+" before the value, and it will work as intended. 
 * @param value 
 * Input from select -> option 
 */
  selectChanges(value){
    switch (+value) {
      case 1:
        this.orderByNameDes();
        break;
      case 2:
        this.orderByNameAsc();
        break;
      case 3: 
        this.orderByPriceDes();
        break;
      case 4: 
        this.orderByPriceAsc();
        break;
      case 5: 
        this.orderByRatingDes();
        break;
      case 6: 
       this.orderByRatingAsc();
       break;
      case 7: 
        this.orderByDeal();
        break;
      default:
        this.setCourseFilter();
        break;
    }
    
  }

  orderByRatingDes(){
    this.filterProducts  = this.courseFilter().sort(
      (a,b) => b.rating-a.rating
    );
  }
  orderByRatingAsc(){
    this.filterProducts  = this.courseFilter().sort(
      (a,b) => a.rating-b.rating
    );
  }
  orderByNameDes(){
    this.filterProducts  = this.courseFilter().sort(
      (a,b) => {if(a.title < b.title) { return -1; }}
    );
  }
  orderByNameAsc(){
    this.filterProducts  = this.courseFilter().sort(
      (a,b) => {if(a.title > b.title) { return -1; }}
    );
  }

  orderByPriceDes(){
    this.filterProducts = this.courseFilter().sort(
      (a,b) => b.price-a.price
    );
  }
  orderByPriceAsc(){
    this.filterProducts = this.courseFilter().sort(
      (a,b) => a.price-b.price
    );
  }
  orderByDeal(){   
    this.filterProducts = this.courseFilter().filter(p => this.filterDeals(p.dealOfDay, "true" ));
  }
  
  filterDeals(a,b){
    return a === b;
  }
  
  async ngOnInit() {
    this.subscribtion = (await this.cartService.getCart())
      .subscribe(cart => this.cart = cart);

  }

  ngOnDestroy() {
    try {
      this.subscribtion.unsubscribe();
      
    } catch (error) {
      console.log(error);
    }
  }

}
