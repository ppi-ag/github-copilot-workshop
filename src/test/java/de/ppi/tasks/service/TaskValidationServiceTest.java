package de.ppi.tasks.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TaskValidationServiceTest {

    @Test
    void validateTaskTitle() {
        TaskValidationService service = new TaskValidationService();
        assertTrue(service.validateTaskTitle("ValidTitle123"));
        assertFalse(service.validateTaskTitle("No"));
        assertTrue(service.validateTaskTitle("Long text that should be valid at least in my opinion"));
    }
}