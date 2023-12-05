package baseball.constants;

public enum GameSetting {
    RESTART("1"),
    FINISH("2"),
    ;

    private final String value;

    GameSetting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
