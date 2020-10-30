package com.securityinternal.myapp.repositories;

import com.securityinternal.myapp.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
