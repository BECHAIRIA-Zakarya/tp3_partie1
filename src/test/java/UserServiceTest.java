import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import exercice01.User;
import exercice01.UserRepository;
import exercice01.UserService;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testGetUserById() {

        UserRepository userRepositoryMock = mock(UserRepository.class);
        User user = new User(1, "Zakarya");
        when(userRepositoryMock.findUserById(1)).thenReturn(user);

        UserService userService = new UserService(userRepositoryMock);
        User result = userService.getUserById(1);

        verify(userRepositoryMock).findUserById(1);
        assertEquals(user, result);
    }
}
