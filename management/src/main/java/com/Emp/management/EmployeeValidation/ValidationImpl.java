package com.Emp.management.EmployeeValidation;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationImpl implements Validations {

    @Override
    public boolean check_email(String email) {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @Override
    public boolean check_name(String name) {
        return ((name!= null)  && (name.length()>=3) && name.length()<=20 && (name.matches("^[a-zA-Z]*$")));
    }

    @Override
    public boolean check_mobNo(String mob_no) {
        Pattern p = Pattern.compile("^\\d{10}$");

        Matcher m = p.matcher(mob_no);

        return (m.matches());
    }

    @Override
    public boolean check_id(int emp_id) {
        return false;
    }
}
