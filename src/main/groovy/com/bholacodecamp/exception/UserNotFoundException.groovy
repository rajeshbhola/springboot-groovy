package com.bholacodecamp.exception


class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("User with id ${id} not found")
    }
}
