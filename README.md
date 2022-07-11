# DBSgit
My Database homeworks (SQL and Java)

The concept of my work is a cat cafe. Because i love cats.
Cats live in the cafe with which customers interact, and customers can also order food.
Workers serve the client and cats.

## Entities

- CatCafe - Name
- Venue - City/Street/Transport
- Cat - Tray/Bowl/Name
- Worker - Position/Name/Salary/Id
- Food - Cost/Type
- Customers - Time/Number
- Order - Time

Tabel - Number/Seats/Occupied
##
I divided all the data into 4 parts:
The restaurant as a place tracks the location, as well as workplaces and the hall in which there are
tables with seats for visitors.
Workers that are divided depending on the profession and interact with other entities.
Visitors that have several options for actions and interact with other entities depending on this.
Cats that track interactions with other entities.
The table, order and food entities only exist when interacting with the main entities.

