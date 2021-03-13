package com.spring.reactive.demo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepo extends ReactiveCrudRepository<EmployeeModel,Integer> {

    @Query("select CASE when count(*) > 0 then 'true' else 'false' END as res FROM T_EMPLOYEE e WHERE e.designation =\'manager\'")
    public Mono<String> manager();

}
