package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userService")
public class UsersServiceImpl implements UsersService{

    private Long    id;
    private String  name;
    private String  password;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void signUp(String name, String password) {
        String hashPass = passwordEncoder.encode(password);
        usersRepository.save(new User(0L, name, hashPass));
    }
}
