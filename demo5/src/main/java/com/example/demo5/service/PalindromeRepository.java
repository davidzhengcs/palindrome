package com.example.demo5.service;

import com.example.demo5.model.Palindrome;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PalindromeRepository extends CrudRepository<Palindrome, Integer> {
    public List<Palindrome> findByOriginal(String original);
}
