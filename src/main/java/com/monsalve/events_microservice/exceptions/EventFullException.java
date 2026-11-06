package com.monsalve.events_microservice.exceptions;

public class EventFullException extends RuntimeException{
     public EventFullException() {
        super("Evento está lotado");
    }

    public EventFullException(String message) {
        super(message);
    }
}
