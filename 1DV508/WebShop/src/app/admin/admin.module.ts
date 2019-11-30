import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CustomFormsModule } from 'ng2-validation';
import { AdminCategoriesComponent } from './admin-categories/admin-categories.component';
import { AdminCoursesComponent } from './admin-courses/admin-courses.component';
import { AdminOrdersComponent } from './admin-orders/admin-orders.component';
import { CategoryFormComponent } from './category-form/category-form.component';
import { ProductFormComponent } from './product-form/product-form.component';
import { AdminAuthGuardService as AdminAuthGuard } from '../services/admin-auth/admin-auth-guard.service';
import { AuthGuardService as AuthGuard } from '../services/auth-guard/auth-guard.service';

@NgModule({
  declarations: [
    AdminCategoriesComponent,
    AdminCoursesComponent,
    AdminOrdersComponent,
    CategoryFormComponent,
    ProductFormComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    CustomFormsModule,
    RouterModule.forRoot(
      [
        {
          path: 'admin/orders',
          component: AdminOrdersComponent,
          // AdminAuthGuard protects the route from non-admin users.
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        {
          path: 'admin/courses/new',
          component: ProductFormComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        { //TODELETE
          path: 'admin/courses/newCategory',
          component: CategoryFormComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        {
          path: 'admin/courses/:id',
          component: ProductFormComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        {
          path: 'admin/courses',
          component: AdminCoursesComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        {
          path: 'admin/categories/newCategory',
          component: CategoryFormComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        {
          path: 'admin/categories/:id',
          component: CategoryFormComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
        {
          path: 'admin/categories',
          component: AdminCategoriesComponent,
          canActivate: [AuthGuard, AdminAuthGuard]
        },
      ]
    )
  ],
  providers: [
    AdminAuthGuard,
    AuthGuard,
  ]
})
export class AdminModule { }
