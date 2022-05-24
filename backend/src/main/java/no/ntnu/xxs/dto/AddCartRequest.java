package no.ntnu.xxs.dto;

import no.ntnu.xxs.entities.user.User;


public class AddCartRequest {

    private User user;

    private long id;

    public AddCartRequest(User user){this.user = user;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public User getUser() {return user;}

    public void setUser(User user) {
        this.user = user;
    }
}
