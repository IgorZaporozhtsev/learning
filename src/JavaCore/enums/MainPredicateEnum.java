package JavaCore.enums;


import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainPredicateEnum {


    public static void main(String[] args) {
        EventPredicate.valueOf("all");

        var enumType = "all"; //
        var all = EventPredicate.valueOf(enumType).test(new Event());

    }
}

class Event{
    EventState state;

    enum EventState{
        done, canceled
    }

    public EventState getState() {
        return state;
    }
}


//we can filter use pre-conditions
enum EventPredicate implements Predicate<Event> {
    all {
        @Override
        public boolean test(Event event) {
            return true;
        }
    },
    completed {
        @Override
        public boolean test(Event event) {
            return event.getState() == Event.EventState.done;
        }
    },
    canceled {
        @Override
        public boolean test(Event event) {
            return event.getState() == Event.EventState.canceled;
        }
    }

}


