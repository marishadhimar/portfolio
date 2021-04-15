package com.marishadhimar.portfolio.repository;

import com.marishadhimar.portfolio.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
