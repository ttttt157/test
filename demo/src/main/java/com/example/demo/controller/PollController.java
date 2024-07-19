package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Poll;
import com.example.demo.service.PollService;

@Controller
public class PollController {

    @Autowired
    private PollService pollService;

    @GetMapping("/")
    public String getAllPolls(Model model) {
        model.addAttribute("polls", pollService.getAllPolls());
        return "polls";
    }

    @GetMapping("/poll/{id}")
    public String getPoll(@PathVariable Long id, Model model) {
        model.addAttribute("poll", pollService.getPoll(id));
        return "poll";
    }

    @PostMapping("/poll")
    public String createPoll(@ModelAttribute Poll poll) {
        pollService.createPoll(poll);
        return "redirect:/";
    }

    @PostMapping("/poll/{pollId}/vote/{optionId}")
    public String vote(@PathVariable Long pollId, @PathVariable Long optionId) {
        pollService.vote(pollId, optionId);
        return "redirect:/poll/" + pollId;
    }
}