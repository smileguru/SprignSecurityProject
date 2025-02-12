package com.example.springsecurityprogect.services;

import com.example.springsecurityprogect.entity.Person;
import com.example.springsecurityprogect.repository.PeopleRepository;
import com.example.springsecurityprogect.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService{
    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        return person.map(PersonDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
