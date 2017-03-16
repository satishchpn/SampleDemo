public List<BookingGuestDetail> getGuestList(long propertyId, ReservationStatus reservationStatu) {

		List<BookingGuestDetail> bgdlist = new ArrayList<>();
		EntityGraph<BookingGuestDetail> eg = entityManager.createEntityGraph(BookingGuestDetail.class);
		eg.addAttributeNodes("companyProfileId");
		eg.addAttributeNodes("pickUpAndDropList");
		StringBuilder sb = new StringBuilder();
		if (reservationStatu.equals(ReservationStatus.InHouse)) {
			sb.append("FROM BookingGuestDetail bookingGuestDetail ");
			sb.append("WHERE bookingGuestDetail.propertyId=:propertyId ");
			sb.append("AND bookingGuestDetail.guestType=:guestType ");
			sb.append("AND bookingGuestDetail.reservationStatus =:reservationStatus ");
			Query query = entityManager.createQuery(sb.toString()).setParameter("reservationStatus", reservationStatu).setParameter("guestType", GuestType.Main).setParameter("propertyId", propertyId);
			query.setHint("javax.persistence.fetchgraph", eg);
			query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);
			bgdlist = query.getResultList();
		
		return bgdlist;
	}


public BookingGuestDetail getBookingGuestDetailObject(long bookingGuestDetailId, long propertyId) {
		List<BookingGuestDetail> boookingGuestDetailList = new ArrayList<BookingGuestDetail>();
		EntityGraph<BookingGuestDetail> eg = entityManager.createEntityGraph(BookingGuestDetail.class);
		eg.addAttributeNodes("roomId");
		StringBuilder sb = new StringBuilder("select distinct bgd FROM BookingGuestDetail bgd ");
		sb.append("WHERE bgd.propertyId=:propertyId ");
		sb.append("AND bgd.bookingGuestDetailId=:bookingGuestDetailId ");
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("propertyId", propertyId);
		query.setParameter("bookingGuestDetailId", bookingGuestDetailId);
		query.setHint("javax.persistence.fetchgraph", eg);
		query.setHint("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);
		boookingGuestDetailList = query.getResultList();
		if (!boookingGuestDetailList.isEmpty()) {
			return boookingGuestDetailList.get(0);
		}
}