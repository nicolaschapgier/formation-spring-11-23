package fr.sncf.d2d.colibri.users.persistence;


import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import fr.sncf.d2d.colibri.users.models.User;

@Repository
public class UsersRepository implements UserDetailsService {
    
    private final List<User> users;

    public UsersRepository(UsersConfiguration usersConfiguration){
        this.users = usersConfiguration.getUsers();
    }

    public List<User> getUsers(){

        return this.users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.users.stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst()
            .map(ApplicationUserDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("user %s does not exist", username)));
    }
}