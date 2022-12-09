package stories;

import characters.*;
import enums.Action;
import enums.ApproximateTime;
import enums.Weather;
import locations.Location;
import planes.Plane;

import java.util.Arrays;

public class MainStory {
    static private Location base = new Location("База Дайера", Weather.STRONG_WIND, 13.87, 44.55);
    static private Location bayMcMerdo = new Location("Залив Мак-Мердо", Weather.WEATHERLESS_AND_SUNNY, 1.55, 78.35);
    static private Location arkham = new Location("Бриг Архэм", Weather.WEATHERLESS_AND_SUNNY, 47.23, 97.543);
    static private Location lakesCamp = new Location("Лагерь Лейка", Weather.HURRICANE, 84.235, 11.243);
    static private Location newYork = new Location("Нью-Йорк", Weather.WEATHERLESS_AND_SUNNY, 51.23, 14.978);
    static private Person dayer = new Geologist("Дайер", 54, base);
    static private Person goonarson = new Sailor("Гунарсон", 40, bayMcMerdo);
    static private Person larsen = new Sailor("Ларсен", 31, bayMcMerdo);
    static private Person douglas = new Sailor("Дуглас", 33, arkham);
    static private Person sherman = new Physicist("Шерман", 28, bayMcMerdo);
    static private Person torfinsen = new Sailor("Торфинсен", 43, arkham);
    static private Person lake = new Biologist("Лейк", 57, lakesCamp);
    static private Person mctay = new Geologist("Мактай", 35, base);
    static private Person denfort = new Biologist("Денфорт", 47, base);
    static private Person george = new Journalist("Джордж", 28, newYork);
    static private class NumberedPlane extends Plane {
        static private int counter = 0;
        private int number;
        NumberedPlane(Location location) {
            super(location);
            counter++;
            this.number = counter;
        }

        @Override
        public String describe() {
            return number + "-ый радиофицированный самолёт команды, расположенный в локации: " + this.getLocation();
        }
    }
    static private Plane first = new NumberedPlane(lakesCamp);
    static private Plane second = new NumberedPlane(lakesCamp);
    static private Plane third = new NumberedPlane(lakesCamp);
    static private Plane fourth = new NumberedPlane(lakesCamp);
    static private Plane fifth = new Plane(bayMcMerdo) {
        @Override
        public String describe() {
            return "Огромный пятый самолёт команды, сконструированный по специальному заказу " +
                    "для перевозки тяжелого оборудования и готовый к полёту стоит в локации " + this.getLocation();
        }
    };
    private MainStory() {}

    public static void start() {
        System.out.println("4-е января:");
        for (ApproximateTime iterator : ApproximateTime.values()) {
            System.out.println(iterator.describe());
            switch (iterator) {
                case ZERO_AM, ONE_AM, TWO_AM, THREE_AM, FOUR_AM, FIVE_AM, SIX_AM, SEVEN_AM -> {
                    System.out.println(base.getWeather());
                    Arrays.asList(dayer, denfort, mctay).forEach(person -> person.setAction(Action.TRYING_TO_SLEEP));
                }
                case EIGHT_AM -> {
                    System.out.println(lakesCamp.toString());
                    System.out.println(lakesCamp.getWeather());
                }

                case TEN_AM -> mctay.setAction(Action.UNSUCCESSFULLY_USING_RADIO);
                case ELEVEN_AM -> dayer.setAction(Action.HAVING_TERRIBLE_GUESSES);
                case ZERO_PM -> {
                    System.out.println(lakesCamp.getWeather());
                    Arrays.asList(first, second, third, fourth).forEach(plane -> System.out.println(plane.describe()));
                }
                case ONE_PM -> base.setWeather(Weather.WEATHERLESS_AND_SUNNY);
                case TWO_PM -> base.setWeather(Weather.STRONG_WIND);
                case THREE_PM -> base.setWeather(Weather.WEATHERLESS_AND_SUNNY);
                case FOUR_PM, FIVE_PM -> dayer.callByRadio(lake);
                case SIX_PM -> {
                    Arrays.asList(dayer, denfort, mctay).forEach(person -> person.setAction(Action.TREMBLING_IN_FEAR));
                    dayer.callByRadio(douglas).callByRadio(torfinsen);
                    Arrays.asList(dayer, denfort, mctay).forEach(person -> person.setAction(Action.FEELING_DETERMINED));
                }
                case SEVEN_PM -> {
                    System.out.println(fifth.describe());
                    Arrays
                            .asList(dayer, denfort, mctay, sherman, goonarson, larsen)
                            .forEach(person -> person.setAction(Action.PREPARING_FOR_FLIGHT));
                    Plane.Baggage baggage = fifth.new Baggage("сани, собаки, тяжелое машинное оборудование");
                }
                case EIGHT_PM -> {
                    Arrays.asList(sherman, goonarson, larsen).forEach(person -> fifth.addPassenger(person));
                    fifth.fly(base);
                }
                case NINE_PM, TEN_PM, ELEVEN_PM -> sherman.callByRadio(dayer);
            }
            System.out.println("\n");
        }
        System.out.println("5-е января:");
        https://google.com
        // ))))))))))))))))))
        for (ApproximateTime iterator : ApproximateTime.values()) {
            System.out.println(iterator.describe());
            switch (iterator) {
                case ZERO_AM -> {
                    fifth.land();
                    Arrays
                            .asList(dayer, sherman, goonarson, larsen, mctay, denfort)
                            .forEach(person -> person.setAction(Action.PARTICIPATING_IN_MEETING));
                }
                case ONE_AM, SIX_AM -> Arrays.asList(dayer, sherman, goonarson, larsen, mctay, denfort)
                        .forEach(person -> person.setAction(Action.PREPARING_FOR_FLIGHT));
                case TWO_AM, THREE_AM, FOUR_AM, FIVE_AM ->
                        Arrays
                                .asList(dayer, sherman, goonarson, larsen, mctay, denfort)
                                .forEach(person -> person.setAction(Action.RESTING));
                case SEVEN_AM -> {
                        fifth.getBaggage();
                        Arrays
                                .asList(dayer, sherman, goonarson, larsen, mctay, denfort)
                                .forEach(person -> fifth.addPassenger(person));
                        fifth.fly(lakesCamp);
                }

                case EIGHT_AM, NINE_AM -> dayer.callByRadio(lake);
                case TEN_AM -> Arrays.asList(dayer, sherman, goonarson, larsen, mctay, denfort)
                        .forEach(person -> person.setAction(Action.HAVING_TERRIBLE_GUESSES));
                case ELEVEN_AM -> dayer.callByRadio(george);
                case ZERO_PM -> {
                    lakesCamp.setWeather(Weather.FOGGY);
                    System.out.println(dayer.getName() + " в возрасте " + dayer.getAge() + " лет потерял мир и покой");
                    System.out.println("\n");
                    break https;
                }
            }
            System.out.println("\n");
        }
        System.out.println("История завершилась");
    }
}
