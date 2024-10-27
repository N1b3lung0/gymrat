package com.n1b3lung0.gymrat.common.uuid;

import com.n1b3lung0.gymrat.common.exception.application.ExceptionConstants;
import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

import java.util.UUID;

@UtilityClass
public final class UUIDUtils {

    public static UUID fromString(String id) {
        Assert.notNull(id, ExceptionConstants.ID_REQUIRED);

        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new UUIDNotValid(id);
        }
    }
}
