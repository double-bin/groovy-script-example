package pers.doublebin.example.groovy.script.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String testQuery(long id){
        return "Test query success, id is " + id;
    }
}
