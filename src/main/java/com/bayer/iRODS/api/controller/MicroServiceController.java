package com.bayer.iRODS.api.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bayer.iRODS.api.service.IpAddressService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.net.UnknownHostException;


/**
 * This  is the controller class with the endpoints of a CRUD.
 * @author 628700
 * @since 0.0.0
 */

@RestController
@RequestMapping("/iRODS-api")
@Api(value = "iRODS microservice controller", description = "This API provides functionality for iRODS")
public class MicroServiceController {
		
    private static final Log log = LogFactory.getLog(MicroServiceController.class);

    private final IpAddressService ipAddressService;

    @Autowired
    public MicroServiceController(IpAddressService ipAddressService) {
        this.ipAddressService = ipAddressService;
    }

    /**
     * Get server ip
     * @return a controller
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ip")
    @ApiOperation(value = "Get server address.", notes = "Return ip address where the server is running from." )
    public ResponseEntity<String> getServerAddress(){
        log.info("Get server address.");
        String serverAddress = "";
		try {
			serverAddress = this.ipAddressService.getServerAddress();
		} catch (UnknownHostException e) {
			serverAddress="<HOST IP NOT FOUND>";
		}
        String ipAddress = new StringBuilder().append("Running from IP address: ").append(serverAddress).append("\n").toString();
        return ResponseEntity.ok(ipAddress);
    }

}
