import { AfterViewInit, Component, Input, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { City } from './models/city';
import { CountryService } from './services/country-service/country.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {
  title = 'city-list';

  searchText: string= '';

  dataSource: MatTableDataSource<City> = new MatTableDataSource<City>();
  constructor(private countryService:CountryService){ }

  fetchData(){
    this.countryService.fetchAllInfo().subscribe((result)=>{
        this.dataSource.data = result;
    });
  }


  ngAfterViewInit() {
    this.fetchData();
  }


  onTextSearch() {
    this.dataSource.filter = this.searchText.toLocaleLowerCase();
  }

}
