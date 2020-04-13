## Database console H2:
```
http://localhost:4000/database
```

## List of curl :

**Create new reservation**
```
curl -X POST "http://localhost:4000/apartmentReservation" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"owner\": { \"name\": \"Jacek\", \"role\": \"Owner\" }, \"price\": 1500, \"apartment\": { \"description\": \"string\", \"name\": \"house1\", \"price\": 1500, \"surface\": 60 }, \"finishReservation\": \"2020-05-06T12:45:30\", \"startReservation\": \"2020-05-01T12:45:30\", \"borrower\": { \"name\": \"Wojtek\", \"role\": \"Borrower\" }}"
```
**Update reservation by ID**
```
curl -X PUT "http://localhost:4000/apartmentReservation/updateReservation/3" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"owner\": { \"name\": \"Jacek\", \"role\": \"Owner\" }, \"price\": 1500, \"apartment\": { \"description\": \"string\", \"name\": \"house1\", \"price\": 1500, \"surface\": 60 }, \"finishReservation\": \"2020-05-07T12:45:30\", \"startReservation\": \"2020-05-02T12:45:30\", \"borrower\": { \"name\": \"Wojtek\", \"role\": \"Borrower\" }}"
```
**Get reservation list by owner**
```
curl -X GET "http://localhost:4000/apartmentReservation/ownerName/Jacek" -H "accept: */*"
```
**Get reservation list for apartment**
```
curl -X GET "http://localhost:4000/apartmentReservation/findApartment/house1" -H "accept: */*"
```

