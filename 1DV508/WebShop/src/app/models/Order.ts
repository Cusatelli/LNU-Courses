import { ShoppingCart } from './shopping-cart';

export class Order {
    datePlaced: number;
    items: any[];
    total: number;
    
    constructor( public userId: string, public shipping: any,
         shoppingCart: ShoppingCart, public totalCost: number ){
        this.datePlaced = new Date().getTime();
        this.totalCost;
        this.items = shoppingCart.items.map(i => {
            return {
              product: {
                title: i.title,
                imageUrl: i.imageUrl,
                price: i.price,
                key: i.key2
              },
              quantity: i.quantity,
              totalPrice: i.totalPrice,
              status: 'In Progress'
            }
          })
    }
}