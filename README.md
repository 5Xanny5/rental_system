Vehicle Rental System
This repository contains a vehicle rental system implemented in Java. The system allows for managing a fleet of vehicles, handling rental transactions, and keeping track of vehicle status. The code is designed to handle various types of vehicles, including cars, bikes, scooters, and electric vehicles.

Class Overview
1. Abstract Class Vehicle
The Vehicle class serves as the base class for all vehicle types in the system. It includes properties such as:

Brand
Model
Year of manufacture
Rental rates (hourly and daily)
The class provides getter and setter methods to manage these properties. It also defines abstract methods for calculating rental prices for short and long durations, as well as for repair costs. These methods will be implemented in subclasses for specific vehicle types.

2. Interface FuelVehicle
The FuelVehicle interface defines methods related to fuel levels for vehicles powered by fuel. It includes:

getFuelLevel(): Retrieves the current fuel level.
refuel(double amount): Refuels the vehicle to the specified level.
3. Class RentStory
The RentStory class describes the rental history of a vehicle, storing information about the vehicle, customer, and rental status. It includes methods for:

Getting and setting the rental status.
Retrieving current rental details like vehicle and customer information.
4. Class Customer
The Customer class represents a customer in the system. It includes:

getName(): Retrieves the customer's name.
setName(String name): Sets the customer's name.
getRentedVehicles(): Returns a list of vehicles currently rented by the customer.
5. Interface ElectricVehicle
The ElectricVehicle interface defines methods related to battery levels for electric vehicles. It includes:

getBatteryPercentage(): Retrieves the current battery percentage.
charge(double percentage): Charges the vehicle to the specified battery percentage.
6. Enum RentStatus
The RentStatus enum represents possible rental states:

RENTED: The vehicle is currently rented.
RETURNED: The vehicle has been returned after rental.
7. Class ElCar
The ElCar class represents an electric car, extending the Car class and implementing the ElectricVehicle interface. It includes properties such as battery capacity, charging time, and electric range. Methods include:

Retrieving and setting battery capacity.
Charging the car to a specific battery percentage.
8. Class Ebike
The Ebike class represents an electric bike, extending the Bike class and implementing the ElectricVehicle interface. It includes:

Battery capacity
Light availability
Foldability
9. Class Rental System
The RentalSystem class represents the core of the rental process, including:

Adding vehicles to the fleet.
Renting and returning vehicles.
Managing vehicle repairs.
Tracking the rental history and financial transactions.
It operates interactively via a console application where the user can perform various operations like renting, returning, and displaying rental history.

10. Class Car
The Car class represents a specific type of vehicle—automobile. It extends the Vehicle class and implements the FuelVehicle interface. It includes:

Fuel type
Number of seats
Current fuel level
11. Class Bike
The Bike class represents a bicycle and extends the Vehicle class. It includes:

Number of gears
Basket availability
12. Class Scooter
The Scooter class represents a scooter, extending the Vehicle class and implementing the ElectricVehicle interface. It includes:

Battery capacity
Rental price calculations
Battery management
Features
Vehicle Management: Add, search, and manage vehicles in the fleet.
Rental Process: Rent, return, and manage rental history.
Repair and Maintenance: Calculate repair costs for different types of vehicles.
Fuel and Battery Management: Refuel or charge vehicles, based on their type.
