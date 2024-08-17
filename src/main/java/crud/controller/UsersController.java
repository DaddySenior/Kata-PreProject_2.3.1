package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


//1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
//2. Должен быть класс User с произвольными полями (id, name и т.п.).
//3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять,
// удалять и изменять юзера.
//4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами. Без
// использования xml. Без Spring Boot.
//5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен
// использоваться EntityManager.
//6. Используйте только GET/POST маппинги
//7. Используйте ReqestParam аннотацию, использование аннотации PathVariable запрещено

@Controller
@RequestMapping("/people")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/people";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.updateUser(user);
        return "redirect:/people";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id", required = true) int id) {
        userService.deleteUser(id);
        return "redirect:/people";
    }
}


//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//        return "redirect:/people";
//    }

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
//        if(bindingResult.hasErrors()) {
//            return "edit";
//        }
//        userService.updateUser(user);
//        return "redirect:/people";
//    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "/show";

//    @PostMapping()
//    public String create(@RequestParam("name") String name, @RequestParam("surname") String surname,
//                         @RequestParam("age") int age,@Valid Model model, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            return "new";
//        }
//        User user = new User();
//        user.setName(name);
//        user.setSurname(surname);
//        user.setAge(age);
//        userService.saveUser(user);
//        return "redirect:/people";
//    }












