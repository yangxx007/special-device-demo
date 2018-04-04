package com.example.demo.dao.device;

import com.example.demo.entity.device.UseRegistCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yang
 * @create_at 17-11-3
 **/
public interface UseRegistCertificateDao extends JpaRepository<UseRegistCertificate,Integer> {
    UseRegistCertificate findByRegistCode(String registCode);
}
