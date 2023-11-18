package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.errorlogbean;

public interface errorrepo extends JpaRepository<errorlogbean, String> {

}
