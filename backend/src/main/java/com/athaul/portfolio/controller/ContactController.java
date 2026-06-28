package com.athaul.portfolio.controller;

import com.athaul.portfolio.dto.ContactRequest;
import com.athaul.portfolio.dto.ContactResponse;
import com.athaul.portfolio.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Public REST API for submitting contact messages.
 */
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactMessageService contactMessageService;

    public ContactController(ContactMessageService contactMessageService) {
        this.contactMessageService = contactMessageService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> submit(@Valid @RequestBody ContactRequest request) {
        ContactResponse response = contactMessageService.submitMessage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
