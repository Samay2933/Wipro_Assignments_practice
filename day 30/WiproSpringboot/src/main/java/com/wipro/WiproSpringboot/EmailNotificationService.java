package com.wipro.WiproSpringboot;

package com.gl.configstyles.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emailNotificationService")
public class EmailNotificationService implements NotificationService {

    private String serviceName;

    public EmailNotificationService(@Value("EMAIL_SERVICE") String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public ServiceResponse sendNotification(String notification) {
        return new ServiceResponse(serviceName, notification);
    }
}