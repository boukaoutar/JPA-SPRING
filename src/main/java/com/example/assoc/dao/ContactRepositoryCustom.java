package com.example.assoc.dao;
import com.example.assoc.entities.Contact;

import java.util.List;

public interface ContactRepositoryCustom {
	public boolean FindByEmailandID(String  email, int id);
	
	public boolean FindByEmail(String  email);
}
