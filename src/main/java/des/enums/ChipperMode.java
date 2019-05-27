package des.enums;

public enum ChipperMode {
    CBC("CBC"), ECB("ECB");
    String value;

    ChipperMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
