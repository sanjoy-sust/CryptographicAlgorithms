package des.enums;

public enum Algorithm {
    DES("DES"), TDES("DESede");
    String value;

    Algorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
