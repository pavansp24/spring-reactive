package com.spring.reactive.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo repo;

    @Autowired
    DatabaseClient dbClient;

    private static Employee apply(EmployeeModel employeeModel) {
        Employee e = new Employee();
        e.setDepartment(employeeModel.getDepartment()).setDesignation(employeeModel.getDesignation()).setFirstName(employeeModel.getFirstName()).setLastName(employeeModel.getLastName()).setQualification(employeeModel.getQualification());
        return e;
    }

    public Flux<Employee> getAll() {
        return repo.findAll().map(EmployeeService::apply);
    }

    public Mono<Employee> save(Employee employee) {
        EmployeeModel model = new EmployeeModel();
        model.setDesignation(employee.getDesignation());
        model.setDepartment(employee.getDepartment());
        model.setFirstName(employee.getFirstName());
        model.setLastName(employee.getLastName());
        model.setQualification(employee.getQualification());
        return repo.save(model).map(EmployeeService::apply);
    }

    public Mono<Employee> update(Employee employee, Integer id) {
        Mono<EmployeeModel> fallback = Mono.error(new HttpStatusCodeException(HttpStatus.NOT_FOUND) {
            @Override
            public HttpStatus getStatusCode() {
                return HttpStatus.NOT_FOUND;
            }
        });
       return repo.findById(id).switchIfEmpty(fallback).map(employeeModel -> {
            employeeModel.setDepartment(employee.getDepartment());
            employeeModel.setDesignation(employee.getDesignation());
            return employeeModel;
        }).flatMap(employeeModel -> repo.save(employeeModel).map(EmployeeService::apply));

    }

    public Mono<Void> delete(Integer id) {
        return repo.deleteById(id);
    }


    /**
     * via db client
     * @return
     */
    public Mono<Employee> getOne() {
        return dbClient.select().from(EmployeeModel.class).fetch().first().map(EmployeeService::apply);
    }


    /**
     * native query
     * @return
     */
    public Mono<Long> getCount() {
        return dbClient.execute("select count(*) as count from  T_EMPLOYEE").map((row, rowMetadata) -> row.get("count", Long.class)).one();
    }

    public Mono<String> checkIfI5() {
        return dbClient.execute("select CASE when count(*) > 0 then 'true' else 'false' END as res from T_EMPLOYEE where designation='i5'").map((row, rowMetadata) -> row.get("res", String.class)).one();
    }

    public Mono<Boolean> manager() {
        return repo.manager()
                .map(val -> Boolean.valueOf(val));
    }
}
