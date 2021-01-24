package com.example.todo.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "todo")
class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 1

    @Column(nullable = false)
    val task: String = ""

    @Column(nullable = false)
    val date: String = Date().toString()

    @Column(nullable = false)
    val done: Boolean? = false
}