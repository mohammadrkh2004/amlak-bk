package ir.amlak.amlaktamrin.exception.impl;


public class EstateDoesnotExists extends RuntimeException {
    public EstateDoesnotExists() {
        super("ملک با این کد رهگیری وجود ندارد");

    }
}
