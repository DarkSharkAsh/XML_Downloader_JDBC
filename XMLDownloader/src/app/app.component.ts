import { Component,OnInit  } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { parse, format } from 'date-fns';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'XML Downloader';
  isLoading: boolean = true;
  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 2000);
  }
  
  constructor( public http:HttpClientModule){}
  
  
   toggleDarkMode():void {
    document.body.classList.toggle("dark-mode");
    const modeIcon:any = document.getElementById("modeIcon");
  
    if (document.body.classList.contains("dark-mode")) {
      modeIcon.classList.remove("fa-sun");
      modeIcon.classList.add("fa-moon");
    } else {
      modeIcon.classList.remove("fa-moon");
      modeIcon.classList.add("fa-sun");
    }
  }
  download(id:string) {

    const numberId = Number(id); // Convert string to number
    const url = `http://localhost:8080/new/${numberId}`;
    window.location.href = url;
  }
 
 
  downloadContractXml(ccid:string,ccdate:string)
  {


const formattedDate = this.convertDateFormat(ccdate);
console.log(ccid +" unformatted "+ ccdate+ " formatted date"+ formattedDate);

  }

  convertDateFormat(date: string): string {
//    Parse the date string as a Date object (assuming the format is MM-DD-YYYY)
    const parsedDate = parse(date, 'MM-dd-yyyy', new Date());

  //  Format the parsed date object to 'dd-MMM-yyyy' (e.g., '01-MAY-2023')
    const formattedDate = format(parsedDate, 'dd-MMM-yyyy');

    return formattedDate;
  }

}
