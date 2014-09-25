-- 12
SELECT COUNT(*) as HotelCount FROM Hotel; 
-- 13 
SELECT AVG(price) as AVGprice FROM Room; 
-- 14 
SELECT SUM(price) FROM Room WHERE type = 'd';
-- 15
SELECT COUNT(guestNo) 
	FROM Booking 
	WHERE dateFrom >= 01/08/2014 
	AND dateFrom >= 31/08/2014 
	AND dateTo >= 01/08/2014 
	AND dateTo >= 31/08/2014;
-- 22
SELECT hotelNo, COUNT(roomNo) AS RoomCount 
	FROM Room 
	GROUP BY hotelNo;
-- 23 
SELECT hotelNo, COUNT(roomNo) AS RoomCount 
	FROM Hotel, Room
	WHERE city = 'London'
	GROUP BY hotelNo;
-- 24 
SELECT hotelNo, AVG(guestNo)
	FROM Booking 	
	WHERE dateFrom >= 2014-08-01 
	AND dateFrom >= 2014-08-31
	AND dateTo >= 2014-08-01
	AND dateTo >= 2014-08-31
	GROUP BY hotelNo;
-- 25
SELECT roomNo FROM Booking WHERE hotelNo = '3';

 