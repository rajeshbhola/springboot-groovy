package com.bholacodecamp.controller

import com.bholacodecamp.entity.User
import com.bholacodecamp.exception.UserNotFoundException
import com.bholacodecamp.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/api/users")
class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController)

    @Autowired
    UserRepository userRepository

    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        log.info("Fetching all users")
        List<User> users = userRepository.findAll()
        return new ResponseEntity<>(users, HttpStatus.OK)
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        log.info("Creating new user with name: ${user.name}")
        User savedUser = userRepository.save(user)
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable Long id) {
        log.info("Fetching user with id: ${id}")
        User user = userRepository.findById(id).orElseThrow({ new UserNotFoundException(id) })
        return new ResponseEntity<>(user, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        log.info("Updating user with id: ${id}")
        User existingUser = userRepository.findById(id).orElseThrow({ new UserNotFoundException(id) })
        existingUser.name = updatedUser.name
        existingUser.email = updatedUser.email
        User savedUser = userRepository.save(existingUser)
        return new ResponseEntity<>(savedUser, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("Deleting user with id: ${id}")
        userRepository.findById(id).orElseThrow({ new UserNotFoundException(id) })
        userRepository.deleteById(id)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT)
    }
}

