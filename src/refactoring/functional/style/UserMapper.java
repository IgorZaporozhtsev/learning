package refactoring.functional.style;

public class UserMapper {

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserName(user.getUsername());
        dto.setFullName(user.getFirstName() + " " + user.getLastName().toUpperCase());
        dto.setActive(user.deactivationDate == null);
        return dto;
    }
}
