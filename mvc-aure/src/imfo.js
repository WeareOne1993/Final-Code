import {inject} from 'aurelia-framework';
import {HttpClient, json} from 'aurelia-fetch-client';

let httpClient = new HttpClient();
@inject(HttpClient)
export class Items {
  heading = 'Items';
  apiKey = "";

  deleteData(a) {
    let remove ='http://localhost:8080/SpringMVCRestAPIDemo/figure/remove/' +a;
    httpClient.fetch(remove, {
      method: "DELETE"
      })
      .then(response => response.json())
      .then(data => {
        console.log(data);
     });
  } 

  constructor(http) {
    http.configure(config => {
      config
        .useStandardConfiguration()
        .withBaseUrl('http://localhost:8080/SpringMVCRestAPIDemo/figure/')
          .withDefaults({
            headers: {
              'content-type': 'application/json',
              'Accept': 'application/json',
              'X-Requested-With': 'Fetch'
            }
          })
    });

    this.http = http;
  }

attach() {

let auth = {
  "id":1,
      "name" : "name",
      "price" : 100,
      "path" : "src"
};
return this.http.fetch('add', {
      method: 'post',
      body: JSON.stringify(auth),
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
      }
    })
    .then(response => response.json())
    .then(response => {
      this.apiKey = response.APIKey;
});
}
}