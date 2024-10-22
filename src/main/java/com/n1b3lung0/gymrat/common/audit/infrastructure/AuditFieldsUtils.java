package com.n1b3lung0.gymrat.common.audit.infrastructure;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

@Slf4j
final class AuditFieldsUtils {
    private static final String AUDIT_FIELDS = "auditFields";

    static void setAuditFieldsToState(Object[] currentState, String[] propertyNames, Object value) {
        int index = ArrayUtils.indexOf(propertyNames, AUDIT_FIELDS);
        if (index >= 0) {
            currentState[index] = value;
        }
    }

    static void setAuditFieldsToEntity(Object entity, AuditFields newAuditFields) {
        try {
            Field auditFields = getAuditFields(entity);
            auditFields.setAccessible(Boolean.TRUE);
            auditFields.set(entity, newAuditFields);
        } catch (IllegalAccessException e) {
            log.error("Value {} could not be set to {}", newAuditFields, entity.getClass().getName());
            throw new RuntimeException(e);
        }
    }

    static AuditFields getAuditFieldsValue(Object entity) {
        AuditFields auditFieldsValue;
        try {
            Field auditFields = getAuditFields(entity);
            auditFields.setAccessible(Boolean.TRUE);
            auditFieldsValue = (AuditFields) auditFields.get(entity);
        } catch (IllegalAccessException e) {
            log.error("Failed to get audit fields value in class {}", entity.getClass().getName());
            throw new RuntimeException(e);
        }
        return auditFieldsValue;
    }

    private static Field getAuditFields(Object entity) {
        Field field;
        try {
            field = entity.getClass().getDeclaredField(AUDIT_FIELDS);
        } catch (NoSuchFieldException e) {
            log.error("Could not find AuditFields in class {}", entity.getClass().getName());
            throw new RuntimeException(e);
        }
        return field;
    }

    static boolean hasAuditFields(String[] propertyNames) {
        return Arrays.stream(propertyNames)
                .anyMatch(name -> StringUtils.equals(name, AUDIT_FIELDS));
    }
}
