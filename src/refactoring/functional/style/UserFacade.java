package refactoring.functional.style;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserFacade {
    private UserRepo userRepo;
    private UserMapper userMapper;

    public List<UserDto> getAllUsers(){
        List<User> users = userRepo.findAll();
        List<UserDto> dtos = new ArrayList<>();
        for (User user:users) {
            UserDto dto = new UserDto();
            dto.setUserName(user.getUsername());
            dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
            dto.setActive(user.deactivationDate == null);
        }
        return dtos;
    }

    public List<UserDto> getAllUsersRefactor1(){
        return userRepo.findAll().stream()
                .map(user -> {
                    UserDto dto = new UserDto();
                    dto.setUserName(user.getUsername());
                    dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
                    dto.setActive(user.deactivationDate == null);
                    return dto;
        }).collect(Collectors.toList());
    }

    public List<UserDto> getAllUsersRefactor2(){
        return userRepo.findAll().stream()
                .map(user -> toDto(user)).collect(Collectors.toList());
    }

    public List<UserDto> getAllUsersRefactor3(){
        return userRepo.findAll().stream()
                .map(this::toDto).collect(Collectors.toList());
    }

    public List<UserDto> getAllUsersRefactor4(){
        return userRepo.findAll().stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserName(user.getUsername());
        dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        dto.setActive(user.deactivationDate == null);
        return dto;
    }
}
