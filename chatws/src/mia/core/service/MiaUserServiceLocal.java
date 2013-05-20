package mia.core.service;

import mia.core.model.MiaUser;

public interface MiaUserServiceLocal {

	MiaUser getUserByUserLogin(String username);

}
