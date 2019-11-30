import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import { AngularFireStorage } from '@angular/fire/storage';
import { map } from 'rxjs/operators';
import { Product } from '../../models/product';

// CRUD courses
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  myArray: Product[] = [];
  products: Product[] = [];
  category: any;
  filterProducts: Product[];
  constructor(private db: AngularFireDatabase, private af: AngularFireStorage) { }

  create(product) {
    return this.db.list('/products').push(product);
  }

  getAll() {
    return this.db.list('/products', ref => (ref.orderByChild('name')))
      .snapshotChanges().pipe(
        map(actions =>
          actions.map(a => ({ key: a.key, ...a.payload.val() } as Product))
        )
      );
  }

  /**
   * OBS This is the part that does not get an actual object from DB
   */
  get(courseID: string) {
    return this.db.object('/products/' + courseID);
  }

  updateProduct(id, product) {
    return this.db.object('/products/' + id).update(product);
  }

  deleteProduct(id) {
    return this.db.object('/products/' + id).remove();
  }

  uploadFile() {
    return this.af;
  }

}
