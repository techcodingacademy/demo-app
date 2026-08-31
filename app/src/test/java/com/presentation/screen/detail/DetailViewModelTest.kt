package com.presentation.screen.detail

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.sql.DriverManager.println

class DetailViewModelTest {
    @Before
    fun setUp() {
        println("SET UP")
    }

    @After
    fun tearDown() {
        println("TEAR DOWN")
    }

    @Test
    fun getUiState() {
        println("GET UI STATE")
    }

    @Test
    fun getUserById() {
        println("GET USER BY ID")
    }

}