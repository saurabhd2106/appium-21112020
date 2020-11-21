package com.mmt.tests;

import org.testng.annotations.Test;

import com.mmt.pages.MmtHomepage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.DeviceSettings;

public class MmtTests {
	
	CommonDriver cmnDriver;
	
	MmtHomepage mmtHomepage;
	
	@Test
	public void verifyAppInit() throws Exception {
		
		DeviceSettings deviceSettings = new DeviceSettings();
		
		deviceSettings.setPlatformName("Android");
		deviceSettings.setPlatformVersion("10");
		deviceSettings.setApp("MakeMyTrip_base.apk");
		deviceSettings.setDeviceName("RZ8N91VR6EL");
		deviceSettings.setUdid("RZ8N91VR6EL");
		
		cmnDriver= new CommonDriver(deviceSettings);
		
		mmtHomepage= new MmtHomepage(cmnDriver.getDriver());
		
		String homePageActivityId= cmnDriver.getActivityId();
		
		System.out.println(homePageActivityId);
		
		System.out.println(cmnDriver.getDeviceTime());
		
		System.out.println(cmnDriver.getBatteryInfo());
		
		mmtHomepage.hotelSearch();
		
		Thread.sleep(5000);
		
		System.out.println(cmnDriver.getActivityId());
		
		cmnDriver.quitApp();
	}

}
