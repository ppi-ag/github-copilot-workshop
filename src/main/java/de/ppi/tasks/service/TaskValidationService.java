package de.ppi.tasks.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TaskValidationService {


    public boolean validateTaskTitle(String title) {
        String regex = "^[A-Za-z][A-Za-z0-9 _-]{4,49}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(title);
        return matcher.matches();
    }
}
