package net.proselyte.autowiring.ex3;

import net.proselyte.autowiring.ex2.IAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Person {
    private Long id;
    private String name;
    private String surname;
    @Value("#{address}")
    private IAddress address;

    public IAddress getAddress() {
        return address;
    }

   // @Autowired(required = false)
   // @Autowired
    public void setAddress(IAddress address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
