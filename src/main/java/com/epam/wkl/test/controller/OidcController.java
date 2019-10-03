package com.epam.wkl.test.controller;

import com.epam.wkl.test.dto.response.BaseResponse;
import com.epam.wkl.test.dto.response.OidcDataDto;
import com.epam.wkl.test.utils.FileUtils;
import com.epam.wkl.test.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
OidcController .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
@RestController
@RequestMapping("/v1")
public class OidcController {

    @Value("${path.to.data.file}")
    private String pathToFile;

    @GetMapping("/login")
    public ResponseEntity<BaseResponse<OidcDataDto>> login() {
        BaseResponse<OidcDataDto> response = JsonUtils.fromJson(FileUtils.getJsonDataFromFile(pathToFile));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
