package com.example.demo5.api;

import com.example.demo5.model.Palindrome;
import com.example.demo5.service.PalindromeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/palindrome")
public class PalindromeController {
    @Autowired
    private PalindromeRepository repository;

    @PostMapping(path="/add")
    public @ResponseBody String addPalindrome(@RequestParam String original) {
        Palindrome p = new Palindrome();
        p.setOriginal(original);
        p.setPalin();
        repository.save(p);
        return "Saved";
    }

    @GetMapping(path="/retrieve/{original}")
    public @ResponseBody String getPalindrome(@PathVariable String original) {
        return repository.findByOriginal(original).get(0).getPalin();
    }
}
