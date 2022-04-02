package bg.tu.varna.sit.movieproject.services;

import bg.tu.varna.sit.movieproject.repositories.UserRepository;

public class LoginService {
    private final UserService userService = UserService.getInstance();
    private final UserRepository userRepository=UserRepository.getInstance();

    public static LoginService getInstance(){
        return LoginService.LoginServiceHolder.INSTANCE;
    }

    private  static class LoginServiceHolder{
        public static final LoginService INSTANCE = new LoginService();
    }
}
