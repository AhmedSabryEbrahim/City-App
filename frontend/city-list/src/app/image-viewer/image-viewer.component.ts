import { Component, Input } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';

@Component({
  selector: 'app-image-viewer',
  templateUrl: './image-viewer.component.html',
  styleUrls: ['./image-viewer.component.css']
})
export class ImageViewerComponent {

  @Input() picUrl: any = '';
  constructor(private readonly sanitizer: DomSanitizer) {}

 
  public get safeUrlPic(): SafeHtml {
    const dynamicHtml = "<img class=city-img src="+this.picUrl+" height=250px width=350px >";
    const safeHtml = this.sanitizer.bypassSecurityTrustHtml(dynamicHtml);
    return safeHtml;
  }
}
