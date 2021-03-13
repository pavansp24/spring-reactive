package com.spring.reactive.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/employee" , produces = "application/json", consumes = "application/json")
public class ReactiveController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public Flux<Employee> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Mono<Employee> save(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @PutMapping("/{id}")
    public Mono<Employee> update(@RequestBody Employee employee, @PathVariable("id") Integer id) {
        return service.update(employee,id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }

    @GetMapping("/first")
    public Mono<Employee> getOne() {
        return service.getOne();
    }

    @GetMapping("/count")
    public Mono<Long> count() {
        return service.getCount();
    }


    @GetMapping("/validate")
    public Mono<String> checkIfI5() {
        return service.checkIfI5();
    }

    @GetMapping("/manager")
    public Mono<Boolean> manager() {
        return service.manager();
    }
}
