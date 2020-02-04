import { Component, OnInit, Input  } from '@angular/core';
import { SearchService } from '../services/search.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public gridData: any;
 
  @Input() index: string;
  
  constructor(	private searchService: SearchService ) {
   
   }

  ngOnInit() { }  
  
  getGridData(index : string) : void {
        this.searchService.getGridData(this.index).subscribe(
          response=>{
            this.gridData = response;
            console.log("data :"+JSON.stringify(response));         
          }
      ); 
   }

}
