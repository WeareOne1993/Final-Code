import 'fetch';
import {HttpClient, json} from 'aurelia-fetch-client';

let httpClient = new HttpClient();

export class paging {
	getData() {
      httpClient.fetch('http://jsonplaceholder.typicode.com/posts/1')
      .then(response => response.json())
      .then(data => {
         return this.data
      });
   }

}