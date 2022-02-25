package com.example.PetStore.User.Service;
import com.example.PetStore.Model.Response;
import com.example.PetStore.User.Model.UserModel;
import com.example.PetStore.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    Response response;
     @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response registerUser(UserModel userModel) {
       if(userRepository.existUserModelByUserName(userModel.getUsername())){
            response=new Response(400,"POST","user already exist");
        }
       else if(userModel.getUsername() == null || userModel.getFirstName()== null || userModel.getPassword() == null || userModel.getPhone() == null){
            response = new Response(400,"POST","Invalid Input");
            return response;
        }
        else if(userModel.getUsername().equals("") || userModel.getFirstName().isEmpty() || userModel.getPassword().isEmpty() || userModel.getPhone().isEmpty()){
            response = new Response(400,"POST","Invalid Input");
            return response;
        }
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
        response = new Response(201,"POST","Sucessfully Created");
        return response;
    }


    public  Response getUser(String username){
        Optional<UserModel>userModel=userRepository.findByUserName(username);

        Response response;
        UserModel user;
        if(!userRepository.existUserModelByUserName(username)){
            response = new Response(404,"GET","User not Found");
            return response;
        }
        user = userRepository.findByUserName(username).get();
        response = new Response(200,"GET","Sucessfully Collected");
        response.setUser(user);
        return response;


    }

    public Response deleteUser(String username){
    Response response;
        //userRepository.deleteByUserName(username);
        if(!userRepository.existUserModelByUserName(username)){
              response = new Response(404,"DELETE","User not Found");
            return response;
        }
        Optional<UserModel> user=userRepository.findByUserName(username);
        userRepository.deleteById(user.get().getId());
        response = new Response(200,"DELETE","Sucessfully Deleted");
        return response;
    }


    }


