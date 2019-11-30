import { Product } from './product';

export class ShoppingCartItem {
  key: string;
  product: Product;
  quantity: number;
  price: number;
  title: string;
  imageUrl: string;
  key2: string;
  dealOfDay: boolean;  
  constructor(init?: Partial<ShoppingCartItem>) {
    Object.assign(this, init);
  }

  get totalPrice() { return this.price * this.quantity; }
}

