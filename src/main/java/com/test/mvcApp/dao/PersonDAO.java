package com.test.mvcApp.dao;

import com.test.mvcApp.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private List<Person> people;
    private static  int person_id = 0;
    {
        people = new ArrayList<>();
        people.add(new Person(person_id++,"Michael"));
        people.add(new Person(person_id++,"Bob"));
        people.add(new Person(person_id++,"Tom"));
        people.add(new Person(person_id++,"Sam"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(person_id++);
        people.add(person);
    }
    public void update(int id,Person updatePerson){
        Person personToUpdated = show(id);
        personToUpdated.setName(updatePerson.getName());

    }
    public void delete(int id){
        people.removeIf(p->p.getId()==id);
    }
}
