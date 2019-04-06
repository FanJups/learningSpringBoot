package com.websystique.springboot.model;
 
import org.hibernate.validator.constraints.NotEmpty;
 
import javax.persistence.*;
import java.io.Serializable;
 
@Entity
@Table(name="USER")
public class User implements Serializable{
 
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
 
    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String name;
 
    @Column(name="AGE", nullable=false)
    private Integer age;
 
    @Column(name="SALARY", nullable=false)
    private double salary;

    public User() {
        super();
    }
    public User(String name,Integer age, double salary) {
        super();
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    public void setId(Integer id)
    {
        this.id =id;
    }

    public Integer getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name =name;
    }

    public String getName()
    {
        return name;
    }

    public void setAge(Integer age)
    {
        this.age =age;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setSalary(double salary)
    {
        this.salary =salary;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; 

        User user = (User) o;

        if (Double.compare(user.salary, salary) != 0) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return age != null ? age.equals(user.age) : user.age == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age
                + ", salary=" + salary + "]";
    }
 

}