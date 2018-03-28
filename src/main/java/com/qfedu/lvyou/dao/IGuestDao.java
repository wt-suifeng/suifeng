package com.qfedu.lvyou.dao;

import java.util.List;

import com.qfedu.lvyou.model.Guest;

public interface IGuestDao {

	List<Guest> getGuests();
	
	void createGuest(Guest guest);
	
	void updateGuest(Guest guest);
	
	void deleteGuest(Guest guest);
	
	Guest getGuestById(String guestId);

}
