package org.apatrios.config.yookassa;

import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.IPAddressStringException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Component
public class YookassaWebhookIpChecker {

    private static final Set<String> YOOKASSA_IPS = Set.of(
            "77.75.156.11",
            "77.75.156.35"
                                                          );

    private static final Set<String> YOOKASSA_RANGES = Set.of(
            "185.71.76.0/27",
            "185.71.77.0/27",
            "77.75.153.0/25",
            "77.75.154.128/25",
            "2a02:5180::/32"
                                                             );

    public boolean isValidRequest(HttpServletRequest request) {
        String ip = extractClientIp(request);
        return isInRange(ip);
    }

    private String extractClientIp(HttpServletRequest request) {
        return request.getRemoteAddr();
    }

    private boolean isInRange(String ip) {
        try {
            if (YOOKASSA_IPS.contains(ip)) return true;

            for (String range : YOOKASSA_RANGES) {
                IPAddress address = new IPAddressString(range).toAddress();
                if (address.contains(new IPAddressString(ip).toAddress())) return true;
            }

            return false;
        } catch (IPAddressStringException e) {
            return false;
        }
    }
}