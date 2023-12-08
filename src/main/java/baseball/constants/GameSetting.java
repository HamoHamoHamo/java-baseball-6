package baseball.constants;

public enum GameSetting {
    RESTART("1"),
    FINISH("2"),
    CONTINUE("3"),
    MIN_NUMBER("1"),
    MAX_NUMBER("9"),
    NUMBER_SIZE("3"),
    ;

    private final String value;

    GameSetting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getNumberValue() {
        return Integer.parseInt(value);
    }
}
