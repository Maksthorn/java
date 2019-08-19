import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
	allowNewServer = false;
	serverStatus = 'No server was created';

  constructor() { 
  	setTimeout( () => {
  		this.allowNewServer = true;
  	},2000);
  }

  ngOnInit() {
  }
  onCreatedServer(){
  	this.serverStatus = 'server was created'
  }

}
