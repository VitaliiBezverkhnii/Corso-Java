package service;

import database.FileDB;

public abstract class ServiceApp {
	
	private FileDB db = new FileDB();

	public FileDB getDb() {
		return db;
	}
}
