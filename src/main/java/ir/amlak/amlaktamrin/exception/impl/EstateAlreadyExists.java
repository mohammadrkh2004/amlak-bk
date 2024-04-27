package ir.amlak.amlaktamrin.exception.impl;


public class EstateAlreadyExists extends RuntimeException {
    public EstateAlreadyExists() {
        super("ملک با این کد رهگیری قبلا ثبت شده است");

    }
}
