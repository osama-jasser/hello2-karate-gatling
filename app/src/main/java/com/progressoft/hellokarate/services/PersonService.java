package com.progressoft.hellokarate.services;

import com.progressoft.hellokarate.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PersonService {

    private HashMap<Integer,Person> map = new HashMap<>();
    private int currentId=0;

    public Person getById(int id) {
        return map.get(id);
    }

    public int add(Person p) {
        map.put(currentId,p);
        return currentId++;
    }
}
