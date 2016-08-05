import {inject} from 'aurelia-framework';
import {HttpClient, json} from 'aurelia-fetch-client';

let httpClient = new HttpClient();
@inject(HttpClient)

export class welcome {
  heading = 'Github Users';
  page = 8;
  pageCur = 1;
  a=0;

  checkData = [];

  checkPro = true;
  checkWatch = false;
  checkJe = false;
  fac = 0;

  dataSearch = [];
  
  editData = false;  
  deleteData = [];
  
 
  addWatch={
      "id" : 1,
      "name" : "name",
      "price" : 100,
      "type" : "watch",
      "brand" : "brand",
      "model" : "model",
      "gender" :"gender",
      "movement" : "movement",
      "watchLabel" : "watchlabel",
      "path" : "\\img\\watch\\1.jpg"
    };



  data2(data){
    console.log(data.push(data[1]));
  }

  countDataType(data){
    var a=0;
    var i;
    for(i=0; i <data.length; i++){
      if(data[i].type == 'watch'){
        a++;
      }
    }
    return a;
  }

  dataType(data,b){
    var i;
    var a = [];
    for(i=0; i < data.length; i++){
      if(data[i].type == b){
        a = a.push(data[i])
      }
    }
    return a;
  }

  constructor(http) {
    http.configure(config => {
      config
        .useStandardConfiguration()
        .withBaseUrl('http://localhost:8080/SpringMVCRestAPIDemo/')
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

  activate() {
    return this.http.fetch('products')
      .then(response => response.json())
      .then(users => this.users = users);
  } 

  add(data,a,b,c,d,e,f,g,h,i,k){
    let auth = {
      "id": a,
      "name" : b,
      "price" : c,
      "type" : d,
      "brand" : e,
      "model" : f,
      "gender" :g,
      "movement" : h,
      "watchlabel" : i,
      "path" : k
    };
    data.push(auth);
  }

  postData(b,c,d,e,f,g,h,i,k) {
    let auth = {
      "name" : b,
      "price" : c,
      "type" : d,
      "brand" : e,
      "model" : f,
      "gender" :g,
      "movement" : h,
      "watchlabel" : i,
      "path" : k
    };
      httpClient.fetch('http://localhost:8080/SpringMVCRestAPIDemo/product/add', {
         method: "POST",
         body: JSON.stringify(auth),
         headers: {
        'Content-Type': 'application/json'
      }
      })
      
      .then(response => response.json())
      .then(data => {
         console.log(data);
      });
   }
   
  updateData(a,b,c,d) {
    let auth = {
      "id":a,
      "name" : b,
      "price" : c,
      "path" :d
    };
    httpClient.fetch('http://localhost:8080/SpringMVCRestAPIDemo/product/update', {
       method: "PUT",
       body: JSON.stringify(auth),
       headers: {
      'Content-Type': 'application/json'
    }
    })
    
    .then(response => response.json())
    .then(data => {
       console.log(data);
    });
 }

 delete(data,a){
  
  var b = data.indexOf(a);
  console.log(b);
  console.log(data.splice(b,1));
  return data;
 }

  deleteDataa(q) {
    let remove ='http://localhost:8080/SpringMVCRestAPIDemo/product/remove/' +q;
    httpClient.fetch(remove, {
      method: "DELETE"
      })
      .then(response => response.json())
      .then(data => {
        console.log('data');
     });
  } 

}