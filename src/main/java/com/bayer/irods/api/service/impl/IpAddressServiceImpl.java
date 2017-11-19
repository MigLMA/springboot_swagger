package com.bayer.irods.api.service.impl;

import org.springframework.stereotype.Service;

import com.bayer.irods.api.service.IpAddressService;

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

        return InetAddress.getLocalHost().getHostAddress();

    }

}
