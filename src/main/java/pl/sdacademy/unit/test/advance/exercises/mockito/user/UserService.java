package pl.sdacademy.unit.test.advance.exercises.mockito.user;

public class UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserService(final UserRepository userRepository, final UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public User getUserById(final Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(final User user) {
        if (userValidator.isUserValid(user)) {
            User userFromDb = userRepository.addUser(user);
            userFromDb.setLastName(userFromDb.getLastName().toUpperCase());
            return userFromDb;
        }
        throw new IllegalArgumentException("User is invalid");
    }
}