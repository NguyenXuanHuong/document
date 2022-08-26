package xing.rujuan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import xing.rujuan.domain.User;
import xing.rujuan.exception.UserNotFoundException;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    ServletContext servletContext;

    @ModelAttribute("roles")
    private Map<String, String> populateRoles() {
        Map<String, String> roleMap = new HashMap<>();
        roleMap.put("Admin", "Admin");
        roleMap.put("DBA", "DBA");
        return roleMap;
    }

    @GetMapping("/add")
    public String getUserForm(@ModelAttribute("newUser") User user, Model model) {
        return "userForm";
    }

    @PostMapping("/add")
    public String saveUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "userForm";
        }

        MultipartFile multipartFile = user.getProfileImage();
        if (multipartFile != null || !multipartFile.isEmpty()) {

            String fileName = servletContext.getRealPath("/") + "resources\\images\\" + multipartFile.getOriginalFilename();
            try {
                multipartFile.transferTo(new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Save to DB
        redirectAttributes.addFlashAttribute("savedUser", user);
        return "redirect:/user/userDetails";
    }

    @GetMapping("/userDetails")
    public String success() {

        return "success";
    }

    @GetMapping("/get")
    public String retriveUser(@RequestParam(required = false, value = "email", defaultValue = "") String email, Model model) {
        if(!"".equals(email)){
            User u = new User();
            u.setName("Miss Xing");
            u.setEmail("rxing@mum.edu");
            model.addAttribute("savedUser", u);
            return "forward:/user/userDetails";
        }else{
            throw new UserNotFoundException("User Not Found");
        }

    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public String handleUserNotFoundException(UserNotFoundException e, Model model){
//        model.addAttribute("msg", e.getMessage());
//        return "error";
//    }


}
