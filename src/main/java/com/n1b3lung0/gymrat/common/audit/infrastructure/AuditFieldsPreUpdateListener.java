package com.n1b3lung0.gymrat.common.audit.infrastructure;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.getAuditFieldsValue;
import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.hasAuditFields;
import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.setAuditFieldsToEntity;
import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.setAuditFieldsToState;

public class AuditFieldsPreUpdateListener implements PreUpdateEventListener {
    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        Object entity = preUpdateEvent.getEntity();
        Object[] state = preUpdateEvent.getState();
        String[] propertyNames = preUpdateEvent.getPersister().getPropertyNames();

        if (hasAuditFields(propertyNames)) {
            AuditFields auditFields = getAuditFieldsValue(entity);
            assert auditFields != null;
            AuditFields updatedAuditFields;
            if (auditFields.getActive()) {
                updatedAuditFields = auditFields.update("n1b3lung0");
            } else {
                updatedAuditFields = auditFields.delete("n1b3lung0");
            }
            setAuditFieldsToEntity(entity, updatedAuditFields);
            setAuditFieldsToState(state, propertyNames, updatedAuditFields);
        }
        return false;
    }
}
