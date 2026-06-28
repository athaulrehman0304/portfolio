package com.athaul.portfolio.service;

import com.athaul.portfolio.domain.ContactMessage;
import com.athaul.portfolio.dto.ContactRequest;
import com.athaul.portfolio.dto.ContactResponse;
import com.athaul.portfolio.mapper.ContactMessageMapper;
import com.athaul.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;
    private final ContactMessageMapper contactMessageMapper;

    public ContactMessageServiceImpl(ContactMessageRepository contactMessageRepository,
                                     ContactMessageMapper contactMessageMapper) {
        this.contactMessageRepository = contactMessageRepository;
        this.contactMessageMapper = contactMessageMapper;
    }

    @Override
    @Transactional
    public ContactResponse submitMessage(ContactRequest request) {
        ContactMessage entity = contactMessageMapper.toEntity(request);
        ContactMessage saved = contactMessageRepository.save(entity);
        return contactMessageMapper.toResponse(saved);
    }
}
