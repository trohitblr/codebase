package com.intute.profile.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    @Test
    void testToString() {
        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("Test");
        Assert.assertEquals("Test",resourceNotFoundException.toString());
    }
}