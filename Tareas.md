*Clase Location*: 
	- Atributos a privado 
	- Implementar el metodo NextLocation 3/10
	- Implementar Distance 4/10
	
*Clase Passenger*:
	- Añadir atributo String taxiName
	- Modificar constructores 
	- Metodo que devuelve localizacion para recogerlo
	- Metodo que devuelve localizacion para llevarlo
	- setTaxiName
	- getTaxiName
	- printPassengerInfo

*Clase Taxi*: 
	- Atributos a private
	- Añadir Passenger passenger (El que lo está ocupando)
	- int passengersTransported (Nº de pasajeros totales) 
	- isFree 
	- notifyPickupArrival (Notifica a la compañia)
	- notifyPassengerArrival (Notifica si el pasajero ha llegado) 
	- pickup (Recoge al pasajero) 
	- offloadPassenger (Dejar a pasajero) 
	- getPassengersTransported
	- setPassengersTransported
	- distanceToTheTargetLocation (Usando distance de location) 
	- act (Debe moverse si tiene destino y no incrementa sus pasos inactivos (No se que es)) 4/10
	- printInfoTaxi
	
*Clase TransportCompany*: 
	- atributo array de Taxis vehicles
	- array de Passenger passengers (Debe estar ordenada por nombre de forma ascendente) 
	- atributo array de assignments (Pares de Passenger y sus Taxis asignados) 
	 - getVehicles
	 - getPassengers
	 - addTaxi
	 - addPassenger
	 - scheduleVehicle (Devuelve un taxi libre, estan ordenados crecientemente por orden de cercania a un objetivo y en caso de empate por el nombre) 
	 - requestPickup (llama a scheduleVehicle y a setPickupLocation para pasarle a un taxi una direccion: Añade a assignments y si no hay libres devuelve false)
	 - arrivedAtPickup (Si el taxi ha llegado a destino lo elimina de assignments) 
	 
*Clase Demo*: Gestiona la simulacion de traslados
	- al menos 2 campos : company y coleccion actors
	- reset: Reinicia la demo con los datos iniciales
		* Elimina los actores previos
		* createActors:Crea los taxis e inserta en actors
		* createPassengers: se crean e insertan en passengers de company
		* showInicialInfo: Informacion de la demo.
			- Nombre
			- Taxis por nombre
			- Pasajeros por nombre
		* runSimulation: recorre los pasajeros y les asigna un taxi
			- Se debe mostrar de que posicion parte y a donde va
	- run: al menos 100 pasos
	- step: es un paso y llama a act
	- showFinalInfo
	
	
