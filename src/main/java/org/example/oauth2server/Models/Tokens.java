package org.example.oauth2server.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.Date;

@Getter
@Setter
@Entity
public class Tokens extends BaseModel {

    private String tokenvalue;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private Date expiryAt;
}
