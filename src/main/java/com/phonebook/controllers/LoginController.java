package com.phonebook.controllers;

import com.phonebook.objects.PhoneBook;
import com.phonebook.service.PhoneBookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private PhoneBookService phoneBookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "index";
    }

    // return phonebook data
    @RequestMapping(value = "/getJsonPhoneBook", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<PhoneBook> getJsonUser() {
        return phoneBookService.getAll();
    }
}
