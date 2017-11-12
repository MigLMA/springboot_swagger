package com.bayer.iRODS.api.service.impl;

import org.springframework.stereotype.Service;

import com.bayer.iRODS.api.service.IpAddressService;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This  is the implementation class for service.
 * @author 628700
 * @since 0.0.0
 */

@Service
public class IpAddressServiceImpl implements IpAddressService {

    public String getServerAddress() throws UnknownHostException {

        final String serverAddress = InetAddress.getLocalHost().getHostAddress();

        return serverAddress;

    }

}
