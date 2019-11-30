import { Component, OnInit, Input } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ShoppingCartService } from 'src/app/services/shopping-cart/shopping-cart.service';
import { ShoppingCart } from 'src/app/models/shopping-cart';

@Component({
  selector: 'product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {
  @Input('product') product: Product;
  @Input('show-actions') showActions = true;
  @Input('shopping-cart') shoppingCart: ShoppingCart;
  @Input('link') link: String;
  @Input('hasLink') hasLink: boolean;

  constructor(private cartService: ShoppingCartService) {
  }

  ngOnInit() {

  }

  addToCart() {
    this.cartService.addToCart(this.product);
  }

}
