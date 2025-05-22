package com.n1b3lung0.gymrat.user.application.delete;

import com.n1b3lung0.gymrat.common.log.application.LogConstants;
import com.n1b3lung0.gymrat.user.application.find.UserFinder;
import com.n1b3lung0.gymrat.user.domain.User;
import com.n1b3lung0.gymrat.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDeleter {

    private final UserFinder finder;
    private final UserRepository repository;

    @Transactional
    public void delete(String id) {

        User user = finder.findById(id);
        User deleted = user.withAuditFields(user.getAuditFields().delete("n1b3lung0"));
        repository.save(deleted);
        log.debug(String.format(LogConstants.DELETED, "user", user));
    }
}
