package com.ised.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;


@RestController
@EnableWebMvc
public class ExcelController {


    @RequestMapping(path = "/xl", method = RequestMethod.GET)
    public ResponseEntity<byte[]> xl() throws IOException {
        // Read TestFile.xlsx from resources folder and return it
        byte[] xlBytes = getClass().getResourceAsStream("/TestFile.xlsx").readAllBytes(); // replace this with your actual Excel file content

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xlsx");

        return new ResponseEntity<>(xlBytes, headers, HttpStatus.OK);
    }
}
