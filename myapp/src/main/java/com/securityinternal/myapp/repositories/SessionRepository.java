package com.securityinternal.myapp.repositories;

import com.securityinternal.myapp.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
