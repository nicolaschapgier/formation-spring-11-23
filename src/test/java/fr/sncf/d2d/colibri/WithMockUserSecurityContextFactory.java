package fr.sncf.d2d.colibri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.stereotype.Component;

@Component
public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithUser> {

    @Autowired
    private UserDetailsService usersRepository;

    @Override
    public SecurityContext createSecurityContext(WithUser annotation) {
        final var user = this.usersRepository.loadUserByUsername(annotation.username());
        final var authentication =  UsernamePasswordAuthenticationToken.authenticated(
            user, 
            "",
            user.getAuthorities()
        );
        final var context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        return context;
    }
    
}
