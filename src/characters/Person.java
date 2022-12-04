package characters;

import enums.Action;
import exceptions.InvalidAgeException;
import exceptions.InvalidNameException;
import interfaces.Actionable;
import interfaces.Movable;
import locations.Location;
import utils.Validation;

import java.util.Objects;

import static utils.Validation.UNDEFINED_AGE;
import static utils.Validation.UNDEFINED_NAME;

abstract public class Person implements Actionable, Movable {
    private final String profession;
    private String name;
    private Action action = Action.DOING_NOTHING;
    private Location location;

    private int age;

    public Person(String name, int age, Location startLocation, String profession) {
        try {
            this.name = Validation.CorrectName.validate(name);
            this.age = Validation.CorrectAge.validate(age);
        } catch (InvalidNameException exception){
            System.out.println(exception.getMessage());
            this.name = UNDEFINED_NAME;
        } catch (InvalidAgeException exception) {
            System.out.println(exception.getMessage());
            this.age = UNDEFINED_AGE;
        }
        this.location = startLocation;
        this.profession = profession;
    }

    public int getAge() {
        return this.age;
    }
    public String getProfession() {
        return this.profession;
    }

    @Override
    public String getName() {return this.name;}

    @Override
    public Action getAction() {
        return this.action;
    }

    @Override
    public Person setAction(Action action) {
        this.action = action;
        System.out.println(this.getName() + " " + this.action.describe());
        return this;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public Person setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Person callByRadio(Person someone) {
        Action thisPreviousAction = this.getAction();
        Action someonePreviousAction = someone.getAction();
        this.setAction(Action.TALKING_BY_RADIO);
        System.out.println(this.getName() + " звонит " + someone.getName());
        if (this.getName().equals("Дайер")) {
            switch (someone.getName()) {
                case "Торфинсен", "Дуглас" -> {
                    System.out.println("Дозвонился!");
                    someone.setAction(Action.TALKING_BY_RADIO);
                    System.out.println(this.getName() + " совещается с персонажем " + someone.getName());
                    System.out.println("Персонажи " + this.getName() + " и " + someone.getName() + " закончили разговор");
                }
                case "Шерман" -> {
                    System.out.println("Дозвонился!");
                    someone.setAction(Action.TALKING_BY_RADIO);
                    System.out.println(this.getName() + " приказал вылетать персонажу " + someone.getName());
                    System.out.println("Персонажи " + this.getName() + " и " + someone.getName() + " закончили разговор");
                }
                case "Лейк" ->
                        System.out.println("Персонаж " + this.getName() + " не может дозвониться до персонажа "
                                + someone.getName());
                case "Джордж" -> {
                    System.out.println("Дозвонился!");
                    System.out.println(this.getName() + " передал всю накопленную информацию персонажу " + someone.getName());
                    System.out.println("Персонажи " + this.getName() + " и " + someone.getName() + " закончили разговор");
                }
                default -> System.out.println("Нет результата от звонка");
            }
        } else if (this.getName().equals("Шерман") && someone.getName().equals("Дайер")) {
            System.out.println("Дозвонился!");
            someone.setAction(Action.TALKING_BY_RADIO);
            System.out.println(this.getName() + " информировал персонажа " + someone.getName());
            System.out.println("Персонажи " + this.getName() + " и " + someone.getName() + " закончили разговор");
        } else {
            System.out.println("Нет результата от звонка");
        }
        if (someone.getAction() != someonePreviousAction)
            someone.setAction(someonePreviousAction);
        return this.setAction(thisPreviousAction);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        if (((Person) obj).getName().intern() != this.getName().intern()) return false;
        if (!(((Person) obj).getLocation().equals(this.getLocation()))) return false;
        if  (((Person) obj).getAction() != this.getAction()) return false;
        if (((Person) obj).getProfession().intern() != this.getProfession().intern()) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getProfession() + " " + this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(profession, name, action, location);
    }
}
