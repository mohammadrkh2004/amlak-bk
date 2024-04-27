package ir.amlak.amlaktamrin.exception.impl;

public class OwnerAlreadyExists extends RuntimeException{
    public OwnerAlreadyExists (){
        super ("کاربر با این کد ملی قبلا ثبت شده است.");
    }


}
