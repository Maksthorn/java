import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Todo } from '../model/Todo';
import { Observable } from 'rxjs';

const httpOptions = {
	headers : new HttpHeaders({
		'Content-Type':'application/json'
	})
}

@Injectable({
  providedIn: 'root'
})
export class TodoService {
todosUrl: string = 'https://jsonplaceholder.typicode.com/todos';
todosLimit = '?_limit=5';


  constructor(private http:HttpClient) { }

//get todos
  getTodos(): Observable<Todo []>{
  	return this.http.get<Todo []>(`${this.todosUrl}${this.todosLimit}`);
  }


//toggle completed
toggleCompleted(todo:todo):Observable<any>{
const url = `${this.todoUrl}/${todo.id}`;
	return this.http.put(url, todo, httpOptions);
}

}
