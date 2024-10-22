package com.n1b3lung0.gymrat.common.audit.infrastructure;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventListenerConfigurer {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    protected void init() {
        EventListenerRegistry registry = entityManagerFactory.unwrap(SessionFactoryImpl.class)
                .getServiceRegistry().getService(EventListenerRegistry.class);

        assert registry != null;
        registry.getEventListenerGroup(EventType.PRE_INSERT)
                .appendListener(new AuditFieldsPreInsertListener());
        registry.getEventListenerGroup(EventType.PRE_UPDATE)
                .appendListener(new AuditFieldsPreUpdateListener());
    }
}
