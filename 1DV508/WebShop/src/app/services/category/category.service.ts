import { Injectable } from '@angular/core';
import { AngularFireDatabase } from '@angular/fire/database';
import { map } from 'rxjs/operators';

@Injectable()
export class CategoryService {

  constructor(public db: AngularFireDatabase) { }

  getAll() {
    return this.db.list('/categories', ref => (ref.orderByChild('name')))
      .snapshotChanges().pipe(
        map(actions =>
          actions.map(a => ({ key: a.key, ...a.payload.val() }))
        )
      );
  }

  get(id) {
    return this.db.object('/categories/' + id);
  }

  getMore(id) {
    return this.db.object('/categories/' + id).valueChanges().subscribe();
  }

  create(categories) {
    return this.db.object('/categories/' + categories.title).set(categories);
  }

  update(id, categories) {
    return this.db.object('/categories/' + id).update(categories);
  }

  delete(id) {
    return this.db.object('/categories/' + id).remove();
  }

}
