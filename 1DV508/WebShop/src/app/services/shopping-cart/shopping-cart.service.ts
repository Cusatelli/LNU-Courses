import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import 'rxjs/add/operator/take';
import { Observable } from 'rxjs';
import { ShoppingCart } from '../../models/shopping-cart';
import { Product } from '../../models/product';
import 'rxjs/add/operator/map';
import { map } from 'rxjs/operators';

@Injectable()
export class ShoppingCartService {
  currentPrice:number;

  constructor(
    private db: AngularFireDatabase
  ) { }

  async removeItem(item: Product) {
    let cartId = await this.getOrCreateCartId();
    this.db.object('/shopping-carts/' + cartId + '/items/' + item.key).remove();
  }

  async clearCart() {
    let cartId = await this.getOrCreateCartId();
    this.db.object('/shopping-carts/' + cartId + '/items').remove();
  }

  async addToCart(product: Product) {
    this.updateItem(product, 1);
  }

  async removeFromCart(product: Product) {
    this.updateItem(product, -1);
  }
  
  async getCart(): Promise<Observable<ShoppingCart>> {
    let cartId = await this.getOrCreateCartId();
    return this.db.object('/shopping-carts/' + cartId).valueChanges()
      .map(x => new ShoppingCart(x['items']));
  }

  private create(){
    return this.db.list('/shopping-carts').push({
      dateCreated: new Date().getTime()
    });
  }

  private getItem(cartId: string, productId: string){
    return this.db.object('/shopping-carts/' + cartId + '/items/' + productId);
  }

  private async getOrCreateCartId(): Promise<string>{
    let cartId = localStorage.getItem('cartId');
    if(cartId) return cartId;
    
    let result = await this.create();
    localStorage.setItem('cartId', result.key);
    return result.key;
  }

  
  /**
   * For some reason, if the course is not deal of the day, 
   * else is never reached and currentPrice is undefined, 
   * so I made a workaround in updateItem
   * to keep the price working. 
   * @param product 
   */
  private isDeal(product:Product){    
    if(product.dealOfDay.valueOf()){
      this.currentPrice = product.reducedPrice;
    } else {
      this.currentPrice = product.price;
    } 
  }

  private async updateItem(product: Product, change: number) {
    let cartId = await this.getOrCreateCartId();    
    let item$ = this.getItem(cartId, product.key);

    this.isDeal(product);
    
    item$.valueChanges().take(1).subscribe(item => {
      let productQuantity = (product.quantity || 0) + change;
      let itemQuantity;
      if (item) {
        itemQuantity = item['quantity'];
        if(item['quantity'] === 0 || productQuantity === 0) {
          return item$.remove();
        }
        item$.update({
        title: product.title,
        imageUrl: product.imageUrl,
        dealOfDay: product.dealOfDay,
        price: this.currentPrice||product.price,//Workaround
        quantity: itemQuantity + change });
      } else {
        itemQuantity = productQuantity;
        if(productQuantity === 0 || itemQuantity === 0) {
          return item$.remove();
        }
        item$.update({
        title: product.title,
        imageUrl: product.imageUrl,
        dealOfDay: product.dealOfDay,
        price: this.currentPrice||product.price,
        quantity: productQuantity });
      }
    })
 
  }
}