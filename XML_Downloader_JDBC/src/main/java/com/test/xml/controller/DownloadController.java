package com.test.xml.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.test.xml.service.PlanService;

@RestController
@CrossOrigin("http://localhost:4200")
public class DownloadController {


	@Autowired
	private PlanService crud;
	
	
	//Faster
	@GetMapping("/new/{idPLAN}")
	 public ResponseEntity<StreamingResponseBody> getName1(@PathVariable String idPLAN) throws FileNotFoundException {

        
        StreamingResponseBody responseBody = outputStream -> {
        	byte[] data = crud.select(idPLAN);


            try {
                outputStream.write(data);
                outputStream.flush();
            } catch (IOException e) {
                // Handle any IOException
                e.printStackTrace();
            }
        };

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", idPLAN+"idname.xml");

        return ResponseEntity.ok()
                .headers(headers)
                .body(responseBody);
    }
	
	
	//slower
	@GetMapping("/old/{idPLAN}")
	 public ResponseEntity<byte []> getName(@PathVariable String idPLAN) throws FileNotFoundException {

       	byte[] data  = crud.select(idPLAN);

          
       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.TEXT_PLAIN);
       headers.setContentDispositionFormData("attachment", idPLAN+"idname.xml");

       return ResponseEntity.ok()
               .headers(headers)
               .body(data);
   }
	
}
