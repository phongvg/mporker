package com.keysoft.pigfarm.common;

import org.junit.jupiter.api.Test;

import com.speedfrwk.cryptography.SimpleAESUtil;

class KeyGenerator {
	
	@Test
	void generateAll() {
		generateDbMasterPassword();
		generateDbRootPassword();
		generateKeycloakAdminPassword();
	}
	
	@Test
	void generateDbMasterPassword() {
		String dbMasterPassword 		= "Admin@123";
		String encryptDbMasterPassword = SimpleAESUtil.encrypt(dbMasterPassword);
		System.out.println("encryptDbMasterPassword: " + encryptDbMasterPassword);
	}
	
	@Test
	void generateDbRootPassword() {
		String dbRootPassword 			= "Admin@123";
		String encryptDbRootPassword = SimpleAESUtil.encrypt(dbRootPassword);
		System.out.println("encryptDbRootPassword: " + encryptDbRootPassword);
	}
	
	@Test
	void generateKeycloakAdminPassword() {
		String keycloakAdminPassword 	= "Admin@123";
//		String keycloakAdminPassword 	= "admin@123";
		String encryptKeycloakAdminPassword = SimpleAESUtil.encrypt(keycloakAdminPassword);
		System.out.println("encryptKeycloakAdminPassword: " + encryptKeycloakAdminPassword);
	}
}
