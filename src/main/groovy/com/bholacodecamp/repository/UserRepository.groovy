package com.bholacodecamp.repository

import com.bholacodecamp.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository extends JpaRepository<User, Long> {
}
