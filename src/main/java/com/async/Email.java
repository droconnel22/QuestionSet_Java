package com.async;

public class Email {
    private final long id;

    public Email(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                '}';
    }
}
