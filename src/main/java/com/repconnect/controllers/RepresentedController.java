package com.repconnect.controllers;

import com.repconnect.represented.RepresentedRequest;
import com.repconnect.represented.RepresentedResponse;
import com.repconnect.represented.RepresentedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RepresentedController {

    private final RepresentedService representedService;

    public RepresentedController(RepresentedService representedService) {
        this.representedService = representedService;
    }

    @PostMapping("/represented")
    public ResponseEntity<RepresentedResponse> saveRepresented(@RequestBody RepresentedRequest representedRequest){
        return representedService.addRepresented(representedRequest);
    }


}
