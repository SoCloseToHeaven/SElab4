package enums;

import interfaces.Describable;

public enum ApproximateTime implements Describable {
    ZERO_AM("нуля ночи"),
    ONE_AM("часа ночи"),
    TWO_AM("двух часов ночи"),
    THREE_AM("трёх часов ночи"),
    FOUR_AM("четырех часов утра"),
    FIVE_AM("пяти часов утра"),
    SIX_AM("шести часов утра"),
    SEVEN_AM("семи часов утра"),
    EIGHT_AM("восьми часов утра"),
    NINE_AM("девяти часов утра"),
    TEN_AM("десяти часов дня"),
    ELEVEN_AM("одиннадцати часов дня"),
    ZERO_PM("двенадцати часов дня"),
    ONE_PM("часа дня"),
    TWO_PM("двух часов дня"),
    THREE_PM("трёх часов дня"),
    FOUR_PM("четырёх часов дня"),
    FIVE_PM("пяти часов вечера"),
    SIX_PM("шести часов вечера"),
    SEVEN_PM("семи часов вечера"),
    EIGHT_PM("восьми часов вечера"),
    NINE_PM("девяти часов вечера"),
    TEN_PM("десяти часов ночи"),
    ELEVEN_PM("одиннадцати часов ночи");


    private String description;
    ApproximateTime(String description) {
        this.description = description;
    }
    @Override
    public String describe() {
        return "Около " +this.description + ":";
    }
}
