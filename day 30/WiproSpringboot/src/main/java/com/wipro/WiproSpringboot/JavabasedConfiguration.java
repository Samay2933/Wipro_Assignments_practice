package com.wipro.WiproSpringboot;
package com.gl.configstyles.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gl.configstyles.service.CallNotificationService;
import com.gl.configstyles.service.SmsNotificationService;

@Configuration
public class JavaBasedConfiguration {

    @Bean(name = "smsNotificationService")
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("SMS_SERVICE");
    }

    @Bean(name = "callNotificationService")
    public CallNotificationService callNotificationService() {
        return new CallNotificationService("CALL_SERVICE");
    }
}