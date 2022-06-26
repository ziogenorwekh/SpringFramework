package com.example.springframwork.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public abstract class GenericController<T,P, S> {
    S service;
    @RequestMapping("/add") public void add(T entity) {

    }
}
