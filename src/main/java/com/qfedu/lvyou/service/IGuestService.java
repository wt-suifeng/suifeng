package com.qfedu.lvyou.service;

import java.util.List;

import com.qfedu.lvyou.model.Guest;

public interface IGuestService {

	List<Guest> getGuests();
	void createGuest(Guest guest);

}
