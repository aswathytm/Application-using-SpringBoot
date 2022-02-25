package com.example.PetStore.User.Controller;
import com.example.PetStore.Model.Response;
import com.example.PetStore.User.Model.UserModel;
import com.example.PetStore.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "petstore/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("{username}")
    public Response getByUserName(@PathVariable String username)
    {
        return userService.getUser(username);
    }
    @DeleteMapping("{username}")
    public Response deleteByUserName(@PathVariable String username)
    {
        return userService.deleteUser(username);
    }


    @PostMapping
    public Response registerNewUser(@RequestBody UserModel userModel)
    {
         return  userService.registerUser(userModel);
    }

}
