package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Poll;
import com.example.demo.repository.PollRepository;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public Poll getPoll(Long id) {
        return pollRepository.findById(id).orElse(null);
    }

    public void vote(Long pollId, Long optionId) {
        Poll poll = pollRepository.findById(pollId).orElseThrow();
        poll.getChoices().stream()
                .filter(option -> option.getId().equals(optionId))
                .forEach(option -> option.setVotes(option.getVotes() + 1));
        pollRepository.save(poll);
    }
}