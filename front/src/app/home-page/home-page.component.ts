import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  mapOptions: google.maps.MapOptions = {
    center: { lat: 45.452465147211, lng:  4.38847282871598 },
    zoom : 2.5
  }
  constructor() { }

  ngOnInit(): void {
  }

}
