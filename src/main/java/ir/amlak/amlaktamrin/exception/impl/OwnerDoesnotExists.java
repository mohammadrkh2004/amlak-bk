package ir.amlak.amlaktamrin.exception.impl;

public class OwnerDoesnotExists extends RuntimeException{
    public OwnerDoesnotExists(){
        super("کاربر با این کد ملی وجود ندارد.");
    }
}
