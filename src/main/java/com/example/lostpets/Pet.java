package com.example.lostpets;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "user must enter the name of the pit")
    @Size(min=1)
    private String name;

    @NotNull(message = "must enter be number")
    @Min(1)
    private long age;

    @NotNull
    @Size(min=1)
    private String type_of_animal;

    private String breed;

    @NotNull
    @Min(1)
    private long owner_contactnumber;

    @NotNull
    @Size(min=1)
    private String colour;

    private String distingushing_features;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getType_of_animal() {
        return type_of_animal;
    }

    public void setType_of_animal(String type_of_animal) {
        this.type_of_animal = type_of_animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getDistingushing_features() {
        return distingushing_features;
    }

    public void setDistingushing_features(String distingushing_features) {
        this.distingushing_features = distingushing_features;
    }

    public long getOwner_contactnumber() {
        return owner_contactnumber;
    }

    public void setOwner_contactnumber(long owner_contactnumber) {
        this.owner_contactnumber = owner_contactnumber;
    }


}


