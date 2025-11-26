package com.example.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Calculator;
import com.example.demo.Repository.OperationRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operators")
public class OperatorController {
	private final OperationRepository repository;
	 
    @PostMapping
    public Calculator performOperation(@RequestBody Calculator operation) {
        double result = 0;

        switch (operation.getOperator()) {
            case "+":
                result = operation.getValue1() + operation.getValue2();
                break;
            case "-":
                result = operation.getValue1() - operation.getValue2();
                break;
            case "*":
                result = operation.getValue1() * operation.getValue2();
                break;
            case "/":
                if (operation.getValue2() != 0)
                    result = operation.getValue1() / operation.getValue2();
                else
                    throw new IllegalArgumentException("Division by zero not allowed");
                break;
            case "^":
            	result = Math.pow(operation.getValue1(),operation.getValue2());
            	break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }

        operation.setOutput(result);
        return repository.save(operation);
    }


}
