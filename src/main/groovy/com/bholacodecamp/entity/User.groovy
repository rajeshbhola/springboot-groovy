package com.bholacodecamp.entity


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "`user`")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    String email
}
