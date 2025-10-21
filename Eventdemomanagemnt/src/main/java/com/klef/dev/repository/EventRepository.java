package com.klef.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.klef.dev.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
