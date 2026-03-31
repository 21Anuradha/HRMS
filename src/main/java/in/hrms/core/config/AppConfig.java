package in.hrms.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value("${app.show-otp:false}")
    private Boolean showOtp;

    public boolean isShowOtp() {
        return Boolean.TRUE.equals(showOtp);
    }
}

