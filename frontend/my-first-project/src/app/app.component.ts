import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-first-project';

 /* // vider le local
  @HostListener('window:beforeunload', ['$event'])
  clearLocalStorage(event: BeforeUnloadEvent) {
    localStorage.clear();
  }*/
}
