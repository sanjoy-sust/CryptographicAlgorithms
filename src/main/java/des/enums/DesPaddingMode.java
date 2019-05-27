package des.enums;

public enum DesPaddingMode {
    NO_PADDING("NoPadding"), PKCS5_PADDING("PKCS5Padding");
    String value;

    DesPaddingMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
