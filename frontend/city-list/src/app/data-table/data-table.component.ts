import { AfterViewInit, Component, EventEmitter, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { City } from '../models/city';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.css']
})
export class DataTableComponent implements AfterViewInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @Input() dataSource!: MatTableDataSource<City>;

  
  constructor(private sanitizer: DomSanitizer) {
  }

  displayedColumns = ['id', 'city_name', 'link'];

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

   
  public safeUrlPic(picUrl: URL) {

    const url = this.sanitizer.bypassSecurityTrustUrl(picUrl.toString());
    console.log("link =>" + picUrl);
    console.log("url =>" + url);
    return url;
  }

}
