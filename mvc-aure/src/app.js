import $ from 'jquery';

export class App {
  configureRouter(config, router) {
    config.title = 'Aurelia';
    config.map([
    	{ route: ['', 'welcome'],  name: 'welcome', moduleId: 'welcome', nav: true, title: 'welcomes demo' },
      	{ route:  'imfo',  name: 'imfo', moduleId: 'imfo', nav: true, title: 'Imfor' },
      	{ route:  'hello',  name: 'hello', moduleId: './test/hello', nav: true, title: 'Huge Test' }
    ]);

    this.router = router;
  }
}
