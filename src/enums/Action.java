package enums;

import interfaces.Describable;

public enum Action implements Describable {
    TREMBLING_IN_FEAR("дрожит в страхе"),
    DOING_NOTHING("ничего не делает"),
    FLYING_IN_PLANE("летит в самолёте"),
    PREPARING_FOR_FLIGHT("готовится к полёту"),
    RESTING("отдыхает"),
    PARTICIPATING_IN_MEETING("принимает участие в совещании"),
    TALKING_BY_RADIO("говорит по радио"),
    FEELING_DETERMINED("преисполняется решимостью действовать"),
    TRYING_TO_SLEEP("пытается поспать"),
    UNSUCCESSFULLY_USING_RADIO("безуспешно пытается связаться по радио"),
    HAVING_TERRIBLE_GUESSES("строит ужасные догадки");
    private final String description;

    Action(String description) {
        this.description = description;
    }

    @Override
    public String describe() {
        return this.description;
    }
}
