package com.athaul.portfolio.service;

import com.athaul.portfolio.dto.ContactRequest;
import com.athaul.portfolio.dto.ContactResponse;

/**
 * Application service for handling inbound contact messages.
 */
public interface ContactMessageService {

    /**
     * Validates (already performed at the boundary) and persists a contact message.
     *
     * @param request the submitted contact details
     * @return a {@link ContactResponse} describing the stored message
     */
    ContactResponse submitMessage(ContactRequest request);
}
