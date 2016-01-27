package me.wilk.robert.asme.entity;

import javax.persistence.*;

/**
 * @author Robert Wilk
 *         Created on 1/20/2016.
 */
@Entity
public class Something {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NAME")
    String name;

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
}
