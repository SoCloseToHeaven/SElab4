package interfaces;


import enums.Action;

public interface Actionable extends Nameable {
    Actionable setAction(Action newAction);
    Action getAction();
}
