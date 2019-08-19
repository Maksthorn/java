import { Component } from '@angular/core';
// you need export the class to use it else where
@Component({
	//add configuration
	//i can use this selector to call this component in other files
	selector:'app-server',
	//add path for html page
	templateUrl:'./server.component.html'
})
export class ServerComponent{
	serverId: number = 10;
	serverStatus: string = 'offline';

	getServerStatus(){
		return this.serverStatus;
	}

}