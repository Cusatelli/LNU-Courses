import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ShoppingCartService } from 'src/app/services/shopping-cart/shopping-cart.service';
import { ProductService } from 'src/app/services/product/product.service';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { FileLinkService } from 'src/app/services/file-link/file-link.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {
  ngOnInit(): void {
    
  }
  @Input('product') product: Product;
  @Input('show-actions') showActions = true;
  @Input('shopping-cart') ShoppingCartComponent;
  @Input('product-card') ProductCardComponent;
  @Input('link') link: String;
  @Input('hasLink') hasLink: boolean;

  
  myProduct: Product = {
    key: '',
    title: '',
    price: 0,
    category: '',
    imageUrl: '',
    stock: 0,
    rating: 0,
    numberOfVotes: 0,
    quantity: 0,
    dealOfDay: false,
    reducedPrice: 0
  };
  productID;
  myProd$: Observable<any>;
  linkObject;
  downloadLink: String;
  selected;
  readOnly = false;

  constructor(private productService: ProductService, 
    private router: Router, private fileLinkService : FileLinkService,
    private cartService: ShoppingCartService) {

    this.productID = this.router.url.substr(this.router.url.lastIndexOf('=') + 1);
    this.myProd$ = productService.get(this.productID).valueChanges();
    this.linkObject = fileLinkService.get(this.productID);
    this.linkObject.snapshotChanges().subscribe(a => this.downloadLink = a.payload.val());
    productService.get(this.productID).snapshotChanges().pipe(
      map(a => ({ key: a.key, ...a.payload.val() } as Product))
      ).subscribe(p => this.myProduct = p);
  }

  rate(rating: number){
    if(this.myProduct.numberOfVotes>0){
      const newRating = (this.myProduct.rating*this.myProduct.numberOfVotes + rating)/(this.myProduct.numberOfVotes + 1);
      this.myProduct.numberOfVotes = this.myProduct.numberOfVotes + 1;
      this.myProduct.rating = newRating;
    } else {
      this.myProduct.numberOfVotes = 1;
      this.myProduct.rating = rating;      
    }
    this.productService.updateProduct(this.productID, this.myProduct);    
  }

 //If readonly false, rate and block rating
  onClic(rate){    
    if(!this.readOnly){
    this.rate(rate);
    }
    this.readOnly = true;
  }

}
