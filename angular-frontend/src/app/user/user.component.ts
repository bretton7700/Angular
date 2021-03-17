import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import{ User } from '../user';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[] = [];

  constructor(private userService:UserService,
    private router:Router) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe((data:User[] )=>{
    console.log(data);
      
      this.users=data;
    });
  }
  userDetails(id:number){
    this.router.navigate(['user-details',id]);

  }




  updateUser(id:number){
    this.router.navigate(['update-users',id]);


  }
  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe(data=> {
      /* this.userService.getUsers(); */
      this.goToUsersList();
      console.log(data);
    })
  }
   
  goToUsersList(){
    this.router.navigate(['users']);
  }

}
