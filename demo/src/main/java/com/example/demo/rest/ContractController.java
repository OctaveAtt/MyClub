package com.example.demo.rest;

import com.example.demo.model.Contract;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("contractRestCtrl")
@RequestMapping(ContractController.URL)
public class ContractController {
    public static final String URL = "/api/contracts";

    @Autowired
    ContractService service;


    @PostMapping
    public void addContract(@RequestBody Contract contract){
        service.add(contract);
    }

    @GetMapping
    public List<Contract> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Contract getById(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @PutMapping
    public void updateContract(@RequestBody Contract contract){
        service.update(contract);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable("id")Long id){
        service.delete(id);
    }


}
