package com.petter.web;

import com.petter.service.DcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hongxf
 * @since 2017-07-17 14:38
 */
@RestController
public class DcController {

    @Resource
    private DcService dcService;

    @GetMapping("/consumer")
    public String dc() {
        return dcService.dc();
    }
}
