package com.n1b3lung0.gymrat.common.audit.infrastructure;

import com.n1b3lung0.gymrat.common.audit.domain.AuditFields;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.hasAuditFields;
import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.setAuditFieldsToEntity;
import static com.n1b3lung0.gymrat.common.audit.infrastructure.AuditFieldsUtils.setAuditFieldsToState;

public class AuditFieldsPreInsertListener implements PreInsertEventListener {
    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        Object entity = preInsertEvent.getEntity();
        Object[] state = preInsertEvent.getState();
        String[] propertyNames = preInsertEvent.getPersister().getPropertyNames();

        if (hasAuditFields(propertyNames)) {
            AuditFields auditFields = AuditFields.create("n1b3lung0");
            setAuditFieldsToEntity(entity, auditFields);
            setAuditFieldsToState(state, propertyNames, auditFields);
        }
        return false;
    }
}
