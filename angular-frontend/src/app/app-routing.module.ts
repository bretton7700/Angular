import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUsersComponent } from './update-users/update-users.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  {path:'users',component:UserComponent},
  {path:'create-user',component:CreateUserComponent},
  {path: '',redirectTo:'users',pathMatch:'full'},
  {path:'update-users/:id',component:UpdateUsersComponent},
  {path:'user-details/:id',component:UserDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
