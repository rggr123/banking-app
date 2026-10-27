package kodevo.banking_app.service;

import kodevo.banking_app.entity.User;

public interface UserService {
    User registerNewUser(String username, String rawPassword);
}
