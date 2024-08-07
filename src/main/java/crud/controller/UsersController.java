package crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


////1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
////2. Должен быть класс User с произвольными полями (id, name и т.п.).
////3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять,
//// удалять и изменять юзера.
////4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами. Без
//// использования xml. Без Spring Boot.
////5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен
//// использоваться EntityManager.
////6. Используйте только GET/POST маппинги
////7. Используйте ReqestParam аннотацию, использование аннотации PathVariable запрещено
//
@Controller
public class UsersController {

    @GetMapping("/")
    public String getUsers() {
        return "users1";
    }
}

//        @GetMapping("/cars")
//        public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
//
//            CarService carService = new CarServiceImp();
//            List<Car> result = carService.getAmountOfCars(count);
//            model.addAttribute("result", result);
//            return "cars";
//        }




