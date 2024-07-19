package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Poll;

public interface PollRepository extends JpaRepository<Poll, Long> {
}