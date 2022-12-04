package enums;

import interfaces.Describable;

public enum Weather implements Describable {
    HURRICANE("бушует ураган"),
    FOGGY("стоит туман"),
    WEATHERLESS_AND_SUNNY("безветренно и солнечно"),
    STRONG_WIND("бушует сильнейший ветер");

    private String description;

    Weather(String description) {
        this.description = description;
    }

    @Override
    public String describe() {
        return description;
    }
}
