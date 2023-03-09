package fr.linuxdockerdesktop.infra.events;

import javafx.event.Event;
import javafx.event.EventType;

public class OnLoadEvent extends Event {

    public OnLoadEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }

}
