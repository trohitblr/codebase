package com.intute.profile.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiExceptionTest {

    @Test
    void testToString() {
        ApiException  apiException = new ApiException("Test");
        Assert.assertEquals("Test",apiException.toString());
    }
}