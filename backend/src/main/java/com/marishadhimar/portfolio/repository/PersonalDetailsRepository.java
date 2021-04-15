package com.marishadhimar.portfolio.repository;

import com.marishadhimar.portfolio.domain.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails,Long> {
}
